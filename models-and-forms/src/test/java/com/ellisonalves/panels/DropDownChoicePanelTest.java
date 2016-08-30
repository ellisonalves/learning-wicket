package com.ellisonalves.panels;

import com.ellisonalves.WicketApplication;
import com.ellisonalves.pojo.Car;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DropDownChoicePanelTest {

    private WicketTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester(new WicketApplication());
        tester.startComponentInPage(new DropDownChoicePanel("panel"));
    }

    @Test
    public void verifyIfAllComponentsWereAddedToDropDownChoicePanel() throws Exception {
        tester.assertComponent("panel:choiceForm", Form.class);
        tester.assertComponent("panel:choiceForm:fruits", DropDownChoice.class);
        tester.assertComponent("panel:choiceForm:cars", DropDownChoice.class);
    }

    @Test
    public void shouldVerifyComponentsInsideFormAndSubmitSuccessfully() throws Exception {
        FormTester formTester = tester.newFormTester("panel:choiceForm");
        assertTrue(formTester.isClearFeedbackMessagesBeforeSubmit());

        Form choiceForm = formTester.getForm();
        assertTrue(choiceForm.isVisible());

        DropDownChoice<String> fruits = (DropDownChoice<String>) choiceForm.get("fruits");
        List<String> fruitsChoices = (List<String>) fruits.getChoices();
        fruits.setModelObject(fruitsChoices.get(1));

        tester.assertModelValue("panel:choiceForm:fruits", fruits.getModelObject());

        DropDownChoice<Car> cars = (DropDownChoice<Car>) choiceForm.get("cars");
        List<? extends Car> choices = cars.getChoices();

        assertEquals(6, choices.size());

        formTester.submit();

        tester.assertNoErrorMessage();
        tester.assertNoInfoMessage();
        tester.assertNotRequired("panel:choiceForm:fruits");
        tester.assertNotRequired("panel:choiceForm:cars");
    }

}