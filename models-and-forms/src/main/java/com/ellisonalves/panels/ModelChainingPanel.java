package com.ellisonalves.panels;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.ellisonalves.pojo.Person;

public class ModelChainingPanel extends Panel {

	private static final long	serialVersionUID	= 1L;

	public ModelChainingPanel(String id, IModel<Person> model) {
		super(id, model);

		Form<?> personsForm = new Form<Object>("personsForm");
		personsForm.add(initPersons(model));
		personsForm.add(new RequiredTextField<String>("name"));
		personsForm.add(new RequiredTextField<String>("surname"));
		personsForm.add(new RequiredTextField<String>("address"));
		personsForm.add(new EmailTextField("email"));

		add(personsForm);
	}

	private DropDownChoice<Person> initPersons(IModel<Person> model) {
		DropDownChoice<Person> persons = new DropDownChoice<Person>("persons", model, Person.personList(),
				new ChoiceRenderer<>("name")) {
			private static final long	serialVersionUID	= 1L;

			@Override
			protected boolean wantOnSelectionChangedNotifications() {
				return true;
			}
		};

		return persons;
	}

}
