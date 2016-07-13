package com.ellisonalves.forms;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

import com.ellisonalves.pojo.Car;

/**
 * Inner class for the component form inside the webpage.
 * 
 * @author Ellison
 */
public class ComponentDropDownChoiceForm extends Form<Serializable> {

	private static final long		serialVersionUID	= 1L;

	private DropDownChoice<String>	fruits;
	private DropDownChoice<Car>		cars;

	/**
	 * Constructor used to attach the class form with the html form.
	 * 
	 * @param id
	 */
	public ComponentDropDownChoiceForm(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(this.fruits = new DropDownChoice<String>("fruits", new Model<String>(), Arrays.asList("apple",
				"strawberry", "watermelon")));
		this.fruits.setNullValid(true);

		add(this.cars = new DropDownChoice<Car>("cars", new Model<Car>(), Car.getCarList(),
				new ChoiceRenderer<>("name", "id")));
	}
}