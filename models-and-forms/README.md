## Model
Model is essentially a face interface which allows components to acess and modify their data without knowing any detail about how they are managed or persisted. Every component has at most one related model, while a model can be shared among different components. The IModel interface just defines the methods needed to get and set a data object using IModel#setObject and IModel#getObject.

If you take a look at the class Component, you will see that any component can get/set its model as well as its data object using the following methods:
- Component#setDefaultModel(model: IModel<?>);
- Component#setDefaultModelObject(object: Object);
- Component#getDefaultModel(): IModel<?>;
- Component#getDefaultModelObject(): Object;

The methods Component#onModelChanged() and Component#onModelChanging() are triggered by Wicket each time a model is modified. As the name says, one of them is when the model is changed and the other when the model has changed. 


- If you try to set a model object on a component without a model, you will receive an RuntimeException error. So, you have two options:
1. Pass a model. (E.g. new TextField("username", Model.of("")), new PasswordTextField("password", Model.of("")), new Label("loginStatus", Model.of("")) )
2. Use #setDefaultModel(new AnotherModelImplementation(object)) to change the way how Wicket access components. 