package com.ellisonalves.panels;

import com.ellisonalves.WicketApplication;
import com.ellisonalves.pojo.Person;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.WicketTester;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class ModelChainingPanelTest {

    private WicketTester tester;

    private ModelChainingPanel panel;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester(new WicketApplication());
        panel = tester.startComponentInPage(new ModelChainingPanel("panel", Model.of(new Person("Ellison", 30))));
    }

    @Test
    public void shouldVerifyIfAllComponentsAreAdded() {
        tester.assertComponent("panel:personsForm", Form.class);
        tester.assertComponent("panel:personsForm:persons", DropDownChoice.class);
        tester.assertComponent("panel:personsForm:name", RequiredTextField.class);
        tester.assertComponent("panel:personsForm:surname", RequiredTextField.class);
        tester.assertComponent("panel:personsForm:address", RequiredTextField.class);
        tester.assertComponent("panel:personsForm:email", EmailTextField.class);

        DropDownChoice<Person> persons = (DropDownChoice<Person>) panel.get("personsForm:persons");
        Assert.assertNotNull("Persons shouldn't be null", persons);

        List<Person> choices = (List<Person>) persons.getChoices();
        assertThat(choices, CoreMatchers.hasItems(Person.personList().toArray(new Person[]{})));
    }

    @Test
    public void shouldShowAHumanChoiceRenderer() throws Exception {
        DropDownChoice<Person> persons = (DropDownChoice<Person>) panel.get("personsForm:persons");
        assertArrayEquals(
                persons.getChoices().toArray(new Person[]{new Person()}),
                Person.personList().toArray(new Person[]{new Person()})
        );
    }

}