package com.ellisonalves.pages;

import com.ellisonalves.WicketApplication;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class FormInDetailsPageTest {

    private WicketTester tester;

    private FormInDetailsPage page;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester(new WicketApplication());
        page = tester.startPage(FormInDetailsPage.class);
        tester.assertRenderedPage(FormInDetailsPage.class);
    }

    @Test
    public void shouldVerifyAllComponentsAddedToThePage() throws Exception {
        tester.assertComponent("feedback", FeedbackPanel.class);
        tester.assertComponent("form", Form.class);
        tester.assertComponent("form:email", TextField.class);
        tester.assertComponent("form:urlValidator", TextField.class);
        tester.assertComponent("form:dateValidator", DateTextField.class);
        tester.assertComponent("form:rangeValidator", TextField.class);
        tester.assertComponent("form:stringValidator", TextField.class);
        tester.assertComponent("form:creditCardValidator", TextField.class);
        tester.assertComponent("form:customValidator", TextField.class);
        tester.assertComponent("form:passInput1", TextField.class);
        tester.assertComponent("form:passInput2", TextField.class);
    }

    @Test
    public void shouldNotSubmitTheAnInvalidFormForm() throws Exception {
        tester.assertFeedback("feedback");

        FormTester formTester = tester.newFormTester("form");
        formTester.setValue("email", "wrongmail.com");
        formTester.setValue("urlValidator", "dasdasdasda");
        formTester.setValue("dateValidator", "");
        formTester.submit();

        Assert.assertFalse(formTester.getForm().isSubmitted());

        tester.assertErrorMessages(
                "The value of 'email' is not a valid email address.",
                "The value of 'urlValidator' is not a valid URL."
        );

    }
}