package com.ellisonalves.pages;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.validation.validator.EmailAddressValidator;

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
        TextField email = new TextField("email");
        email.add(EmailAddressValidator.getInstance());
    }

}
