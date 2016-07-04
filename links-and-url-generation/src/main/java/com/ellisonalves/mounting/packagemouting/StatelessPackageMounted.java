package com.ellisonalves.mounting.packagemouting;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class StatelessPackageMounted extends WebPage {

	private static final long	serialVersionUID	= 1L;

	public StatelessPackageMounted(PageParameters parameters) {
		super(parameters);

		setStatelessHint(true);

		add(new StatelessLink<Object>("goHome") {

			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				setResponsePage(getApplication().getHomePage());
			}
		});
	}

}
