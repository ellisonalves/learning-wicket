package com.ellisonalves.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.Model;

import com.ellisonalves.pojo.Person;

public class ModelChainingDropDownChoicePage extends WebPage {

	private static final long		serialVersionUID	= 1L;

	private DropDownChoice<Person>	personsList;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Model<Person> listModel = new Model<Person>();

		ChoiceRenderer<Person> person = new ChoiceRenderer<Person>("name");
	}
}
