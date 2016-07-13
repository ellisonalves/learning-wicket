package com.ellisonalves;

import org.apache.wicket.markup.html.WebPage;

import com.ellisonalves.forms.LoginCompoundPropertyModelForm;

public class LoginPageCompoundPropertyModel extends WebPage {

	private static final long	serialVersionUID	= 1L;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new LoginCompoundPropertyModelForm("loginForm"));
	}

}
