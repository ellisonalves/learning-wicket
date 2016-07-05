package com.ellisonalves;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import com.ellisonalves.pojo.Login;

public class LoginPageCompoundPropertyModel extends WebPage {

	private static final long	serialVersionUID	= 1L;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new LoginCompoundPropertyModelForm("loginForm"));
	}

	public class LoginCompoundPropertyModelForm extends Form<Serializable> {

		private static final long	serialVersionUID	= 1L;

		private Login				login;

		public LoginCompoundPropertyModelForm(String id) {
			super(id);
			this.login = new Login();

			setDefaultModel(new CompoundPropertyModel<Serializable>(login));

			add(new Label("loginStatus"), new TextField<Serializable>("username"), new PasswordTextField(
					"password"));
		}

		@Override
		protected void onSubmit() {
			if (login.getUsername().equals("test") && login.getPassword().equals("test"))
				login.setLoginStatus("Congratulations!");
			else
				login.setLoginStatus("Wrong username or password!");
		}
	}

}
