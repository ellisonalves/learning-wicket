package com.ellisonalves;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.ellisonalves.mounting.packagemouting.StatefulPackageMount;
import com.ellisonalves.mounting.singlepage.MountedPage;
import com.ellisonalves.mounting.singlepage.MountedPageWithPlaceholder;

/**
 * Application object for your web application. If you want to run this application without deploying, run the
 * Start class.
 * 
 * @see com.ellisonalves.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		mountPage("/pageMount", MountedPage.class);

		// mountPage("/pageMount/${foo}/otherSegment", MountedPageWithPlaceholder.class); // Parameter is
																		// mandatory
		mountPage("/pageMount/#{foo}/otherSegment", MountedPageWithPlaceholder.class); // Parameter is
																		// optional
		
		mountPackage("/mountPackage", StatefulPackageMount.class);

		// RequestCycle.get().urlFor(MountedPage.class, null);
	}
}
