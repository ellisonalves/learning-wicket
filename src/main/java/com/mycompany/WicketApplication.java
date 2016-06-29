package com.mycompany;

import org.apache.wicket.DefaultMarkupIdGenerator;
import org.apache.wicket.ISessionListener;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.pages.ExceptionErrorPage;
import org.apache.wicket.markup.html.pages.PageExpiredErrorPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.IRequestCycleListener;
import org.apache.wicket.serialize.java.JavaSerializer;
import org.apache.wicket.settings.ExceptionSettings;
import org.apache.wicket.util.lang.Bytes;

/**
 * Application object for your web application. If you want to run this application without deploying, run the
 * Start class.
 * 
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	private static final String	APPLICATION_KEY	= "learning_wicket";

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return MainTemplate.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		// strategy to serialize wicket pages
		// Other options to serialization:
		// - https://github.com/EsotericSoftware/kryo
		// - http://ruedigermoeller.github.io/fast-serialization/
		// these serialization libraries are provided by wicketStuff project.
		getFrameworkSettings().setSerializer(new JavaSerializer(APPLICATION_KEY));

		// Strategy of markup id generator
		getMarkupSettings().setMarkupIdGenerator(new DefaultMarkupIdGenerator());

		// There are two cache levels that wicket allow to set: cache and page
		// store file.
		// This method set the size for page store file
		getStoreSettings().setMaxSizePerSession(Bytes.kilobytes(500));

		// This method sets the maximum number of page instances that will be
		// saved into application-scoped cache:
		getStoreSettings().setInmemoryCacheSize(50);

		// Page Expiration
		// When we try to access a page id that is not inside a session it is
		// expired.
		// To set a custom page when view expire, just set the method
		// getApplicationSettings().setPageExpiredErrorPage(MyCustomPage.class);
		getApplicationSettings().setPageExpiredErrorPage(PageExpiredErrorPage.class);

		/*
		 * We can use IRequestCycleListener interface to implement a custom listener to interact with the
		 * wicket's request life cycle. That interface provide hook methods for this puporse:
		 * 
		 * - onBeginRequest() called when the RequestCycle is about to start handling the request;
		 * 
		 * - onEndRequest() called when the RequestCycle has finished to handle the request
		 * 
		 * - onDetach() called after the request handling has completed and the RequestCycle is about to be
		 * detached from its thread. The default implementation invokes detach() on the current session.
		 * 
		 * - There are other methods to see in javadoc.
		 */
		IRequestCycleListener myListener = null;
		getRequestCycleListeners().add(myListener);

		/*
		 * To create a listener to session we can use the ISessionListener interface and override
		 * onCreateMethod.
		 */
		ISessionListener mySessionListener = null;
		getSessionListeners().add(mySessionListener);

		/*
		 * In DEVELOPMENT mode the default error page is ExceptionErrorPage.class
		 * 
		 * In DEPLOYMENT mode the default error page is InternalErrorPage.class
		 */
		getApplicationSettings().setInternalErrorPage(ExceptionErrorPage.class);

		// show default developer page
		getExceptionSettings().setUnexpectedExceptionDisplay(ExceptionSettings.SHOW_EXCEPTION_PAGE);

		// show internal error page
		getExceptionSettings().setUnexpectedExceptionDisplay(ExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);

		// show no exception page when an unexpected exception is thrown
		getExceptionSettings().setUnexpectedExceptionDisplay(ExceptionSettings.SHOW_NO_EXCEPTION_PAGE);

		mountPage("/SwappingLabels", SwappingLabels.class);	
	}

}
