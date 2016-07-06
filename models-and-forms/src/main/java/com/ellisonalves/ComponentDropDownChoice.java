package com.ellisonalves;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.Model;

public class ComponentDropDownChoice extends WebPage {

	private static final long	serialVersionUID	= 1L;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new ComponentDropDownChoiceForm("form"));
	}

	public class ComponentDropDownChoiceForm extends Form<Serializable> {
		private static final long	serialVersionUID	= 1L;

		public ComponentDropDownChoiceForm(String id) {
			super(id);
			List<String> fruits = Arrays.asList("apple", "strawberry", "watermelon");
			add(new DropDownChoice<String>("fruits", new Model<String>(), fruits) {
				private static final long	serialVersionUID	= 1L;
				{
					setNullValid(true);
				}
			});
			IChoiceRenderer<? super Car> choiceRenderer = new ChoiceRenderer<>("name", "id");
			add(new DropDownChoice<Car>("cars", new Model<Car>(), Car.getCarList(), choiceRenderer));
		}
	}

	private static class Car implements Serializable {

		private static final long	serialVersionUID	= 1L;

		private Long				id;
		private String				name;

		public Car(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
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
