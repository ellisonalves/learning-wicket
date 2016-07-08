package com.ellisonalves;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

public class ComponentDropDownChoice extends WebPage {

	private static final long	serialVersionUID	= 1L;

	private Form<Serializable>	form;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(this.form = new ComponentDropDownChoiceForm("form"));
	}

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
		 * @param id
		 */
		public ComponentDropDownChoiceForm(String id) {
			super(id);
		}

		@Override
		protected void onInitialize() {
			super.onInitialize();

			add(this.fruits = new DropDownChoice<String>("fruits", new Model<String>(), Arrays.asList(
					"apple", "strawberry", "watermelon")));
			this.fruits.setNullValid(true);

			add(this.cars = new DropDownChoice<Car>("cars", new Model<Car>(), Car.getCarList(),
					new ChoiceRenderer<>("name", "id")));
		}

	}

	/**
	 * A simple pojo for this example.
	 * 
	 * @author Ellison
	 *
	 */
	private static class Car implements Serializable {
		private static final long	serialVersionUID	= 1L;

		public Car(Long id, String name) {
			super();
		}

		public static List<Car> getCarList() {
			return new ArrayList<ComponentDropDownChoice.Car>() {
				private static final long	serialVersionUID	= 1L;
				{
					add(new Car(1l, "Polo"));
					add(new Car(2l, "Duster"));
					add(new Car(3l, "306"));
					add(new Car(4l, "Brava"));
					add(new Car(5l, "Audi a4"));
					add(new Car(6l, "Astra"));
				}
			};
		}

	}

}
