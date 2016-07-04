package com.ellisonalves.mounting.packagemouting;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class StatefulPackageMount extends WebPage {

	private static final long	serialVersionUID	= 1L;

	public StatefulPackageMount(PageParameters parameters) {
		super(parameters);

		add(new Link<Object>("goHome") {

			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				setResponsePage(getApplication().getHomePage());
			}
		});
	}

}
