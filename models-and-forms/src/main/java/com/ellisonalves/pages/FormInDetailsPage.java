package com.ellisonalves.pages;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.*;

import java.util.Calendar;
import java.util.Date;

/**
 * What happends when a form is submited:
 * <p>
 * 1. Form validation.
 * 1.1. User input is checked to see if it satisfies the validations rules set on the form. Wicket converts all the data sent into Java Objects.
 * 1.2. If it fails, feedback messages are displayed to the user.
 * <p>
 * 2. If the form is valid then the models are updated with the converted files obtained from the validation step.
 * <p>
 * 3. Callback methods are invoked: onSubmit() and onError().
 * 3.1. onSubmit() is called when there aren't validation errors
 * 3.2. onError is called when there are validation errors.
 * <p>
 * The default implementation of these methods are empty by default. Therefore, we'll need to override them in order to provide some behavior.
 */
public class FormInDetailsPage extends HomePage {

    public FormInDetailsPage() {

        add(new FeedbackPanel("feedback"));

        Form form = new Form("form") {
            @Override
            protected void onSubmit() {
                super.onSubmit();
            }
        };

        // EmailTextField can be used
        TextField email = new TextField("email", Model.of(""));

        email.add(EmailAddressValidator.getInstance());

        // UrlTextField can be used
        TextField<String> url = new TextField<>("urlValidator", Model.of(""));
        url.add(new UrlValidator());

        DateTextField date = new DateTextField("dateValidator", Model.of(new Date()));
        date.add(DateValidator.minimum(Calendar.getInstance()));

        TextField<String> range = new TextField<>("rangeValidator", Model.of(""));
        range.add(RangeValidator.range(1, 10));

        TextField<String> string = new TextField<>("stringValidator", Model.of(""));
        string.add(StringValidator.lengthBetween(1, 10));

        TextField<String> creditCard = new TextField<>("creditCardValidator", Model.of(""));
        creditCard.add(new CreditCardValidator());

        TextField<String> passInput1 = new TextField<>("passInput1", Model.of(""));
        TextField<String> passInput2 = new TextField<>("passInput2", Model.of(""));

        TextField<String> customValidator = new TextField<>("customValidator", Model.of(""));

        form.add(
                email,
                url,
                date,
                range,
                string,
                creditCard,
                passInput1,
                passInput2,
                customValidator
        );

        form.add(new EqualPasswordInputValidator(passInput1, passInput2));

        add(form);
    }

}
