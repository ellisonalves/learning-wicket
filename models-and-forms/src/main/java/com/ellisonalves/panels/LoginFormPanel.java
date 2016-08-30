package com.ellisonalves.panels;

import com.ellisonalves.pojo.Login;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import java.io.Serializable;

public class LoginFormPanel extends Panel {

    public LoginFormPanel(String id, IModel<Login> loginModel) {
        super(id);

        add(new FeedbackPanel("loginStatus"));

        add(initLoginForm(loginModel));
    }

    private Form<Login> initLoginForm(IModel<Login> loginModel) {
        IModel<Login> loginCompound = new CompoundPropertyModel<Login>(loginModel);
        final Login login = loginModel.getObject();

        Form<Login> form = new Form<Login>("loginForm", loginCompound) {
            @Override
            protected void onSubmit() {
                if (login.getUsername().equals("test") && login.getPassword().equals("test"))
                    info("User and pass are correct!");
                else
                    error("Wrong username or password!");
            }
        };
        form.add(
                new RequiredTextField<Serializable>("username"),
                new PasswordTextField("password")
        );

        return form;
    }
}
