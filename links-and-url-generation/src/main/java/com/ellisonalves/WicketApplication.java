package com.ellisonalves;

import org.apache.wicket.DefaultMapperContext;
import org.apache.wicket.core.request.mapper.CryptoMapper;
import org.apache.wicket.core.request.mapper.IMapperContext;
import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.UrlPathPageParametersEncoder;

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

		setRootRequestMapper(new CryptoMapper(getRootRequestMapper(), this));
		
		// Pages and resources must be mounted after we have set CryptoMapper

		mountPage("/pageMount/", MountedPage.class);

		// mountPage("/pageMount/${foo}/otherSegment", MountedPageWithPlaceholder.class); // Parameter is
		// mandatory
		mountPage("/pageMount/#{foo}/otherSegment/", MountedPageWithPlaceholder.class); // Parameter is
																		// optional

		mountPackage("/mountPackage/", StatefulPackageMount.class);

		mount(new MountedMapper("/mountedPath/", MountedPage.class, new UrlPathPageParametersEncoder()));

		// RequestCycle.get().urlFor(MountedPage.class, null);
	}

	@Override
	protected IMapperContext newMapperContext() {
		return new DefaultMapperContext() {
			@Override
			public String getBookmarkableIdentifier() {
				return super.getBookmarkableIdentifier();
			}

			@Override
			public String getPageIdentifier() {
				return super.getPageIdentifier();
			}
		};
	}
}
