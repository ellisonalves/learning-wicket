package com.ellisonalves;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.ellisonalves.mounting.packagemouting.StatefulPackageMount;
import com.ellisonalves.mounting.packagemouting.StatelessPackageMounted;
import com.ellisonalves.mounting.singlepage.MountedPage;
import com.ellisonalves.mounting.singlepage.MountedPageWithPlaceholder;

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

		add(new Link<Object>("pageWithNamedIndexParam") {
			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				PageParameters parameters = new PageParameters();
				parameters.set(0, "foo");
				parameters.set(1, "bar");
				parameters.add("baz", "baz");

				setResponsePage(PageWithParameters.class, parameters);
			}
		});

		String googleQuery = "http://www.google.com/search?q=apache wicket";
		add(new ExternalLink("externalSite", googleQuery));

		String dynamicAnchorLabel = "My Dynamic Label";

		add(new ExternalLink("dynamicAnchorLabel", googleQuery, dynamicAnchorLabel));

		add(new Link<Object>("mountedPage") {
			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				setResponsePage(MountedPage.class);
			}
		});

		add(new Link<Object>("mountedPageWithPlaceholder") {
			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				PageParameters parameters = new PageParameters();
				// parameters.add("foo", "foo");
				setResponsePage(MountedPageWithPlaceholder.class, parameters);
			}

		});

		add(new Link<Object>("mountedPackageStateful") {
			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				setResponsePage(StatefulPackageMount.class);
			}
		});

		add(new StatelessLink<Object>("mountedPackageStateless") {
			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				setResponsePage(StatelessPackageMounted.class);
			}
		});

		add(new Link<Object>("controllingPageParameters") {

			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				PageParameters parameters = new PageParameters();
				parameters.add("fooParam", "fooValue");
				parameters.add("barParam", "barValue");
				
				setResponsePage(MountedPage.class, parameters);
			}

		});
	}
}
