package com.ellisonalves.forms;

import com.ellisonalves.pojo.Login;
import org.apache.wicket.markup.html.form.Form;

/**
 * Created by enas on 29/08/2016.
 */
public abstract class BasicLoginForm<T> extends Form<T> {

    protected Login login;

    public BasicLoginForm(String id) {
        super(id);
        this.login = new Login();
    }

    @Override
    protected void onSubmit() {
        if (login.getUsername().equals("test") && login.getPassword().equals("test"))
            info("User and pass are correct!");
        else
            error("Wrong username or password!");
    }

}
