package com.ellisonalves;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

	private static final long	serialVersionUID	= 1L;

	public HomePage() {
		add(new Link<Object>("pageWithIndexParam") {

			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				PageParameters parameters = new PageParameters();
				parameters.add("foo", "foo");
				parameters.add("bar", "bar");

				setResponsePage(PageWithParameters.class, parameters);
			}
		});
	}

}
