## Model
Model is essentially a facade interface which allows components to acess and modify their data without knowing any detail about how they are managed or persisted. Every component has at most one related model, while a model can be shared among different components. The IModel interface just defines the methods needed to get and set a data object using IModel#setObject and IModel#getObject.

If you take a look at the class Component, you will see that any component can get/set its model as well as its data object using the following methods:
- Component#setDefaultModel(model: IModel<?>);
- Component#setDefaultModelObject(object: Object);
- Component#getDefaultModel(): IModel<?>;
- Component#getDefaultModelObject(): Object;

The methods Component#onModelChanged() and Component#onModelChanging() are triggered by Wicket each time a model is modified. As the name says, one of them is when the model is changed and the other when the model has changed. 

The class org.apache.wicket.model.Model is a basic implementation of IModel and it can wrap any object that implements the interface java.io.Serializable. Remember wicket stores data object in the web session through java serialization. That's why you should provide an Seriazable object. However, we can use detaching capability and work with non-serializable objects as data model.

Wicket provides a set of IModel implementations wich should be enough for the most of your needs, but when you need to do something specific you will need to provide an instance of IModel to your component: 
```
IModel timeStampModel = new Model<String>(){
	@Override
		public String getObject() {
			return new Date().toString();
		}
	};
add(new Label("timeStamp", timeStampModel));
```

You have always to provide a model for your components! If you try to set a data object on a component without a model, you will receive an RuntimeException error. So, you have two options:

* Pass a model. (E.g. new TextField("username", Model.of("")), new PasswordTextField("password", Model.of("")), new Label("loginStatus", Model.of("")) )
* Use #setDefaultModel(new AnotherModelImplementation(object)) to change the way how Wicket access its components.

### Models and JavaBeans
 Wicket provides two special model classes in order to overcoming the impedance mismatch between web technologies and OO paradigm. These models are:
 
 * org.apache.wicket.model.PropertyModel;
 * org.apache.wicket.model.CompoundPropertyModel.
 
#### Property Model
 By using a property model aproach you need to set each of fields of your class to its corresponding property in the view. So, wicket will keep the view and the data object conected and updated. Let's see an example:
 
 Our pojo (data object) is:
 ```
 public class Login implements Serializable {

	private static final long	serialVersionUID	= 1L;
	
	private String				loginStatus;
	private String				username;
	private String				password;
	
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
 ```
 
 Our form with Property Model is:
 ```
 public class LoginPropertyModelForm extends Form<Serializable> {

		private static final long	serialVersionUID	= 1L;

		private Login				login			= new Login();

		public LoginPropertyModelForm(String id) {
			super(id);

			add(new TextField<>("username", new PropertyModel<String>(login, "username")),
					new PasswordTextField("password", new PropertyModel<String>(login, "password")),
					new Label("loginStatus", new PropertyModel<String>(login, "loginStatus")));
		}

		@Override
		protected void onSubmit() {
			if (login.getUsername().equals("test") && login.getPassword().equals("test"))
				login.setLoginStatus("Congratulations!");
			else
				login.setLoginStatus("Wrong username or password!");
		}
	}
 
 ```
 
 Note that PropertyModel has just one constructor with two parameters:
 
 * The serializable pojo;
 * The name of the property we want to read/write (Property expression).
 
##### PropertyModel characteristics
- Support dotted notation to select sub properties (e.g. new PropertyModel(pojoInstance, "property.subProperty"));
- It is null-safe;
- It can access Array and List specifying an index (e.g. new PropertyModel(pojoInstance, "arrayOrListProperty.0.objectOfThisArrayOrList"));
- It can access maps using squared brackets (e.g. new PropertyModel(pojoInstance, "mapProperty[key]".propertyName));
 
### CompoundPropertyModel with Wicket Forms
It is a particular kind of model which is usually used in conjunction with model inheritance. So, when a component needs to use a model but none has been assigned to it, it will search through the whole container hierarchy for a parent with an inheritable model (implements org.apache.wicket.model.IComponentInheritedModel). Once a CompoundPropertyModel has been inherited by a component, it will behave just like a PropertyModel using the id of the component as property expression.

Wicket provides org.apache.wicket.markup.html.form.Form class to handle web forms. The method onSubmit() is called whenever a form has been submitted and you can override it to perform custom actions. Note that wicket doesn't map the submit button of the html form. So, you just need to use the standard HTML button and Wicket will catch the onSubmit event. 

The purpose of FormComponent is to store the corresponding user input into its model when the form is submitted. The form is responsible for mapping input values to the corresponding components, avoiding us of manually synchronizing models with input fields and vice versa.

 In order to assign CompoundPropertyModel to one container of a given component we should use setDefaultModel(new CompoundPropertyModel(pojoInstance)). Let's see an example:
 ```
 public class LoginCompoundPropertyModelForm extends Form<Serializable> {

		private static final long	serialVersionUID	= 1L;

		private Login				login;

		public LoginCompoundPropertyModelForm(String id) {
			super(id);
			this.login = new Login();

			setDefaultModel(new CompoundPropertyModel<Serializable>(login));

			add(new Label("loginStatus"), new TextField<Serializable>("username"), new PasswordTextField(
					"password"));
		}

		@Override
		protected void onSubmit() {
			if (login.getUsername().equals("test") && login.getPassword().equals("test"))
				login.setLoginStatus("Congratulations!");
			else
				login.setLoginStatus("Wrong username or password!");
		}
	}
 ```
 
 As you can see we don't need to specify a PropertyModel for each component we have inside view. Another important thing is that you should notice the id of the components are the same as the property name in our pojo. By default, CompoundPropertyModel consider that they are the same. However, for some reason you need to specify diferent ids in View and Pojo you can use the bind method like this:
 
 ```
 public class LoginCompoundPropertyModelForm extends Form<Serializable> {

		private static final long	serialVersionUID	= 1L;

		private Login				login;

		public LoginCompoundPropertyModelForm(String id) {
			super(id);
			this.login = new Login();
			CompoundPropertyModel compoundModel = new CompoundPropertyModel<Serializable>(login); 
			setDefaultModel(compoundModel);

			add(new Label("loginStatus", compoundModel.bind("otherId")), 
					new TextField<Serializable>("username", compoundModel.bind("otherId")), 
					new PasswordTextField("password", compoundModel.bind("otherId"))
			);
		}

		@Override
		protected void onSubmit() {
			if (login.getUsername().equals("test") && login.getPassword().equals("test"))
				login.setLoginStatus("Congratulations!");
			else
				login.setLoginStatus("Wrong username or password!");
		}
	}
 ```
 
#### Some components until now
- Label -> Used to bind labels in html file;
- TextField -> Used to bind text fields in html file, without any particular behavior or restriction on the allowed values;
- PasswordTextField -> SubType of TextField, must be used with an <input> tag with the attribute type set to "password". By default, it cleans its value at each request and it is required.  

##### DropDownChoice
In order to use the DropDownChoice we need to provide three parameters:
- Id;
- A model containing the current selected item. (Not required if we use CompoundPropertyModel);
- A lista of options to display: Model or java.util.List;

```
List<String> fruits = Arrays.asList("apple", "strawberry", "watermelon");
form.add(new DropDownChoice<String>("fruits", new Model(), fruits));
```

But the example above is really simple. It is common that the information to be displayed comes from an data object (pojo) and in these cases we need to use the interface ChoiceRenderer as the following example:
```
IChoiceRenderer<? super Car> choiceRenderer = new ChoiceRenderer<>("name", "id");
add(new DropDownChoice<Car>("cars", new Model<Car>(), Car.getCarList(), choiceRenderer));
```

