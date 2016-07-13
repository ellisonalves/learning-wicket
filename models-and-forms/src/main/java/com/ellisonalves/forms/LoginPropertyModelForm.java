package com.ellisonalves.forms;

import java.io.Serializable;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.ellisonalves.pojo.Login;

public class LoginPropertyModelForm extends Form<Serializable> {

	private static final long	serialVersionUID	= 1L;

	private Login				login			= new Login();

	public LoginPropertyModelForm(String id) {
		super(id);

		add(new TextField<>("username", new PropertyModel<String>(login, "username")),
				new PasswordTextField("password", new PropertyModel<String>(login, "password")),
				new Label("loginStatus", new PropertyModel<String>(login, "loginStatus")));
	}

	@Override
	protected void onSubmit() {
		if (login.getUsername().equals("test") && login.getPassword().equals("test"))
			login.setLoginStatus("Congratulations!");
		else
			login.setLoginStatus("Wrong username or password!");
	}
}