package com.ellisonalves;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class LoginPageDefaultModel extends WebPage {

	private static final long	serialVersionUID	= 1L;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new LoginDefaultModelForm("loginForm"));
	}

	public class LoginDefaultModelForm extends Form<Serializable> {

		private static final long	serialVersionUID	= 1L;

		private TextField<String>	usernameField;
		private PasswordTextField	passwordField;
		private Label				loginStatus;

		public LoginDefaultModelForm(String id) {
			super(id);

			usernameField = new TextField<>("username", Model.of(""));
			passwordField = new PasswordTextField("password", Model.of(""));
			loginStatus = new Label("loginStatus", Model.of(""));

			add(usernameField);
			add(passwordField);
			add(loginStatus);
		}

		@Override
		protected void onSubmit() {
			String username = (String) usernameField.getDefaultModelObject();
			String password = (String) passwordField.getDefaultModelObject();

			if (username.equals("test") && password.equals("test"))
				loginStatus.setDefaultModelObject("Congratulations!");
			else
				loginStatus.setDefaultModelObject("Wrong username or password!");
		}
		
	}

}
