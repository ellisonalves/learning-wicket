package com.ellisonalves.forms;

import com.ellisonalves.pojo.Login;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;

import java.io.Serializable;

public class LoginCompoundPropertyModelForm extends BasicLoginForm<Login> {

    public LoginCompoundPropertyModelForm(String id) {
        super(id);

        setDefaultModel(new CompoundPropertyModel<Serializable>(login));

        add(
                new RequiredTextField<Serializable>("username"),
                new PasswordTextField("password")
        );

    }

}