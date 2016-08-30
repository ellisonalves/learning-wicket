package com.ellisonalves.forms;

import com.ellisonalves.pojo.Login;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.PropertyModel;

public class LoginPropertyModelForm extends BasicLoginForm<Login> {

    public LoginPropertyModelForm(String id) {
        super(id);

        add(
                new RequiredTextField<>("username", new PropertyModel<String>(login, "username")),
                new PasswordTextField("password", new PropertyModel<String>(login, "password"))
        );
    }

}