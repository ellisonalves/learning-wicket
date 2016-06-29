# wicket-learning

## Wicket usefull links

[WicketStuff] (https://github.com/wicketstuff/core)

## About wicket configuration

To configure wicket you need to extend a class called WebApplication (org.apache.wicket.protocol.http.WebApplication) and override its methods.
At this first moment, you will need to override two methods:
	* ### getHomePage() -> As its name says, it will define the HomePage class. 
	* #### init() -> Here we will define several settings of wicket like as:
		* #### MarkupSettings
			* Strategy to set up the markup id generator using getMarkupSettings().setMarkupIdGenerator(YOUR_STRATEGY). To define your own strategy you need to implement IMarkupIdGenerator interface. The default class for this purpose is DefaultMarkupIdGenerator class;
		
		* #### StoreSetting 
			* Strategies to serialize wicket pages. Wicket has two levels to serialize objects (cache and page store file) and its default serialization options. Nevertheless, we can use the *wicketstuff* project to modify it. You can use these libraries [Fast](https://github.com/wicketstuff/core/tree/master/serializer-fast2) and [Kryo](https://github.com/wicketstuff/core/tree/master/serializer-kryo2);
			
			* Use getStoreSettings().setMaxSizePerSession(Bytes.kilobytes(PAGE_FILE_SIZE)) to set the maximum size of page instances saved into store file; (Disk)
			
			* Use getStoreSettings().setInmemoryCacheSize(IN_MEMORY_SIZE) to set the maximum number of page instances saved into application and session scoped cache. (In memory)
		
		* #### ApplicationSettings
			* PageExpiration. Occurs when we try to access a page id that is not inside a session and it is expired. To set a custom page when view expire just set the method getApplicationSettings().setPageExpiredErrorPage(PageExpiredErrorPage.class). If you need to create a custom page, extends AbstractErrorPage and create your own error page.
		
		
	