package com.ellisonalves;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

public class ComponentDropDownChoice extends WebPage {

	private static final long	serialVersionUID	= 1L;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new ComponentDropDownChoiceFrom("form"));
	}

	public class ComponentDropDownChoiceFrom extends Form<Serializable> {
		private static final long	serialVersionUID	= 1L;

		public ComponentDropDownChoiceFrom(String id) {
			super(id);

			List<String> fruits = Arrays.asList("apple", "strawberry", "watermelon");
			add(new DropDownChoice<String>("fruits", new Model<String>(), fruits));
		}
	}

}
