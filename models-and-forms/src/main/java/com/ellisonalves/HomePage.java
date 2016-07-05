package com.ellisonalves;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long	serialVersionUID	= 1L;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *             Page parameters
	 */
	public HomePage(final PageParameters parameters) {
		add(new Label("message", "If you see this message wicket is properly configured and running"));

		add(new Link<Serializable>("gotoLoginFormDefaultModel") {
			private static final long	serialVersionUID	= 1L;
			@Override
			public void onClick() {
				setResponsePage(LoginPageDefaultModel.class);
			}
		});
		
		add(new  Link<Serializable>("gotoLoginFormCompoundPropertyModel") {
			private static final long	serialVersionUID	= 1L;
			@Override
			public void onClick() {
				setResponsePage(LoginPageCompoundPropertyModel.class);
			}
		});
	}
}
