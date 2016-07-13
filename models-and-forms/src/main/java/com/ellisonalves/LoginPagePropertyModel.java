package com.ellisonalves;

import org.apache.wicket.markup.html.WebPage;

import com.ellisonalves.forms.LoginPropertyModelForm;

public class LoginPagePropertyModel extends WebPage {

	private static final long		serialVersionUID	= 1L;

	private LoginPropertyModelForm	loginPropertyModelForm;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(this.loginPropertyModelForm = new LoginPropertyModelForm("loginForm"));
	}

}
