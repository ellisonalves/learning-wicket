package com.ellisonalves.panels;

import com.ellisonalves.pojo.Person;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class ModelChainingPanel extends Panel {

    public ModelChainingPanel(String id, IModel<Person> model) {
        super(id, model);

        Form personsForm = new Form("personsForm");
        personsForm.add(initPersons(model));
        personsForm.add(new RequiredTextField<String>("name"));
        personsForm.add(new RequiredTextField<String>("surname"));
        personsForm.add(new RequiredTextField<String>("address"));
        personsForm.add(new EmailTextField("email"));

        add(personsForm);
    }

    private DropDownChoice<Person> initPersons(IModel<Person> model) {
        DropDownChoice<Person> persons = new DropDownChoice<Person>("persons", model, Person.personList(), new ChoiceRenderer<>("name")) {
            @Override
            protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
        };

        return persons;
    }

}
