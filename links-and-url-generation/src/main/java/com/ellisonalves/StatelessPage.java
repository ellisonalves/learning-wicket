package com.ellisonalves;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class StatelessPage extends WebPage {

	private static final long	serialVersionUID	= 1L;
	private int				index			= 0;

	public StatelessPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		setStatelessHint(true);

		add(new StatelessLink<Object>("statelessLink") {
			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				// It will always print zero
				System.out.println(index++);
			}
		});
	}

}
