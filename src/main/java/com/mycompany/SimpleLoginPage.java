package com.mycompany;

public class SimpleLoginPage extends MainTemplate {

	private static final long serialVersionUID = 1L;

	public SimpleLoginPage() {
		super();
		replace(new LoginPanel(CONTENT_COMPONENT));
		getMenuPanel().setVisible(false);
	}

}
