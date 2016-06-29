# wicket-learning
This document is about my study of Wicket 7.3.0.

## Wicket usefull links

[WicketStuff] (https://github.com/wicketstuff/core)

## General Wicket Configuration
To configure wicket you need to extend a class called WebApplication (org.apache.wicket.protocol.http.WebApplication) and override its methods. Your WebApplication class will looks like this:

```
public class WicketApplication extends WebApplication {

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
	}
}
```

At this first moment, you will need to override two methods:
- **getHomePage()** -> As its name says, it will define the HomePage class. 
- **init()** -> Inside this method we can define several settings of wicket like as:
	- **MarkupSettings**
		- Strategy to set up the markup id generator using getMarkupSettings().setMarkupIdGenerator(YOUR_STRATEGY). To define your own strategy you need to implement IMarkupIdGenerator interface. The default class for this purpose is DefaultMarkupIdGenerator class;
		
	- **StoreSettings**
		- Strategies to serialize wicket pages. Wicket has two levels to serialize objects (cache and page store file) and its default serialization options. Nevertheless, we can use the *wicketstuff* project to modify it. You can use these libraries [Fast](https://github.com/wicketstuff/core/tree/master/serializer-fast2) and [Kryo](https://github.com/wicketstuff/core/tree/master/serializer-kryo2);
			
		- Use getStoreSettings().setMaxSizePerSession(Bytes.kilobytes(PAGE_FILE_SIZE)) to set the maximum size of page instances saved into store file; (Disk)
			
		- Use getStoreSettings().setInmemoryCacheSize(IN_MEMORY_SIZE) to set the maximum number of page instances saved into application and session scoped cache. (In memory)
		
	- **ApplicationSettings**
		- **PageExpiration** occurs when we try to access a page id that is not inside a session and it is expired. To set a custom page when view expire just set the method getApplicationSettings().setPageExpiredErrorPage(PageExpiredErrorPage.class). If you need to create a custom page, extends AbstractErrorPage and create your own error page.
		- **InternalErrorPage**, In DEVELOPEMENT mode the default error page is ExceptionErrorPage.class and in DEPLOYMENT mode it is InternalErrorPage.class. It is possible to change it extending AbstractErrorPage in order to create your own internal error page. After that, use getApplicationSettings().setInternalErrorPage(YourErrorPage.class) to inform wicket the new error page.
	
	- **RequestCycleListener and SessionListener**
		- **RequestCycleListener** is used to interact with wicket's request life cycle. So, you can implement the interface IRequestCycleListener in order to override its hook methods: onBeginRequest(), onEndRequest(), onDetach().
			- **onBeginRequest()**, called when the RequestCycle is about to start handling the request.
			- **onEndRequest()**, called when the RequestCycle has finished to handle the request.
			- **onDetach()**, called after the request handling has completed and the RequestCycle is about to be detached from its thread. The default implementation invokes detach() on the current session.
			- You can define listeners using getRequestCycleListeners().add(myListener);
		- **SessionListener** is used to interact with wicket's life cycle. Its usage is similar to RequestCycleListener, you just have to implement ISessionListener in order to override its hook methods: onCreated(Session session), onUnbound(String sessionId).
			- **onCreated(Session session)**, called when a new instance of session is created.
			- **onUnbound(String sessionId)**, informs the listener that session with specific id has been unbound.
	- **ExceptionSettings**, you can define whether wicket will show an unexpected exception page or not using getExceptionSettings().setUnexpectedExceptionDisplay(...) method.
		- **ExceptionSettings.SHOW_EXCEPTION_PAGE**, show the default developer page.
		- **ExceptionSettings.SHOW_INTERNAL_ERROR_PAGE**, show internal error page.
		- **ExceptionSettings.SHOW_NO_EXCEPTION_PAGE**, show no exception page when an unexpected exception is thrown.
		- It is possible to override getExceptionMapperProvider() in order to use custom mapper exception.
		- To handle ajax errors, wicket will render the configured error page by default. If you want to handle it on javascript onFailure callback it is necessary add this setting in getExceptionSettings().setAjaxErrorHandlingStrategy(ExceptionSettings.AjaxErrorStrategy.INVOKE_FAILURE_HANDLER); 
		
		
		
	
