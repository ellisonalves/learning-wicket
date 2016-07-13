package com.ellisonalves;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.Model;

import com.ellisonalves.pojo.Person;

public class ModelChainingDropDownChoice extends WebPage {

	private DropDownChoice<Person>	personsList;

	private static final long		serialVersionUID	= 1L;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Model<Person> listModel = new Model<Person>();

		ChoiceRenderer<Person> person = new ChoiceRenderer<Person>("name");
	}
}
