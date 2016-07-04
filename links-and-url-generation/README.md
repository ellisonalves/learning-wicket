## PageParameters
Wicket use PageParameters class to get named parameters passed through query strings (Url). Considering these parameters are name-value pairs, PageParameters offers methods like: ***add(String name, Object value)***, ***set(String name, Object value)***, ***remove(String name)***, ***get(String name)*** just as Map interface from Java.
We need to extends WebPage class and override its constructor with **WebPage(PageParameters pageParameters)**. That constructor will be used to build the page URL and it can be retrieved at a later time with **OurPageClass#getPageParameters()** method. Let�s see an example how we can use it:


### Named Parameters
Focusing in Java class only, we need to create a link (Remember, you'll need to create a .html file for this class). This link will add some parameters to URL and call another page:
```
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
```

Now, when a user click on link, the page PageWithParameters will be called. We can get parameters from URL creating a new page able to read them:
```
public class PageWithParameters extends WebPage {

	private static final long	serialVersionUID	= 1L;

	public PageWithParameters(PageParameters parameters) {
		super(parameters);
	}
	
}
```

The generated URL is **/wicket/bookmarkable/com.ellisonalves.PageWithParameters?foo=foo&bar=bar** and the reason is wicket will try to generate a static URL when a page is instatiated using a constructor with no argument or a constructor that accepts only a PageParameters. This is a bookmarkable URL and you can copy and paste it.

### Indexed Parameters
We can use indexed parameters and mix them with named parameters too. Indexed parameters are also handled by the PageParameters.class and the method **set(int index)** is used to set them instead of **add(String, Object)**.

```
public class HomePage extends WebPage {

	private static final long	serialVersionUID	= 1L;

	public HomePage() {
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
	}
}
```

The resulting url from the code above is: **wicket/bookmarkable/com.ellisonalves.PageWithParameters/foo/bar?baz=baz**.

### Bookmarkable pages
Bookmarkable pages can be linked directly inside markup files without writing any Java code using <wicket:link> tag.

```
<wicket:link>
	<a href="HomePage.html">HomePage</a>
	<br />
	<a href="anotherpackage/SubpackagePage.html">SubPackagePage</a>
</wicket:link>
```

Java class and html file:

```
package com.ellisonalves.anotherpackage;

import org.apache.wicket.markup.html.WebPage;

public class SubpackagePage extends WebPage {

	private static final long	serialVersionUID	= 1L;

}

<!DOCTYPE html>
<html xmlns:wicket="http://wicket.apache.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>SubpackagePage.html</h1>

</body>
</html>

```
Remember, the href attribute must contain the package-relative path to a page. The package hierarchy is reflected by the href attributes. (package-path/class-name)
Note that any link to the current page (Self Link) is disable.

You can configure the markup to render disabled links changing the MarkupSettings in your WicketApplication class.

```
@Override
public void init()
{
	super.init();
	//wrap disabled links with <b> tag
	getMarkupSettings().setDefaultBeforeDisabledLink("<b>");
	getMarkupSettings().setDefaultAfterDisabledLink("</b>");
}

```

### External Links
We can place an anchor to an external page directly inside the markup file. In order to build an external link we must specify the value of the href attribute using a model or a plain string.

html:

```
<a wicket:id="externalSite">Search me on Google!</a>
```

Java code:
```
String googleQuery = "http://www.google.com/search?q=apache wicket";
add(new ExternalLink("externalSite", googleQuery));

add(new ExternalLink("externalSite", googleQuery, "Dynamic Label for link"));
```


### Stateless links
To work with stateless pages you'll need to use stateless links. Wicket provides the convenience class org.apache.wicket.markup.html.link.StatelessLink to do this kind of job. Keep in mid that Wicket generates a new instance of a stateless page also to serve stateless links, so the code inside the onClick() method can not depend on instance variables because they will always be used in their initial state. Just because when you click on a stateless link wicket will create a new instace of the webpage.

```
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

```

### Generating URLs

#### Mouting a single page

In WicketApplication class we can define how pages are mounted using the mountPage(String path, Class<T> pageClass). Using this method, you are setting the path for a specified class. (Wicket WebPage class)

```
@Override
	public void init()
	{
		super.init();
		
		mountPage("/pageMount", MountedPage.class);
		
		// mountPage("/pageMount/${foo}/otherSegment", MountedPageWithPlaceholder.class); // Parameter is mandatory
		// mountPage("/pageMount/#{foo}/otherSegment", MountedPageWithPlaceholder.class); // Parameter is optional
	}
```

If you need to retrieve the path to some MountedPage, you can use:
```
RequestCycle.get().urlFor(MountedPage.class, null);
```

When you need to pass parameters to your mounted pages, you can use placeholders to do it. Let's take a look:
WicketApplication, init method:

```
mountPackage("/pageMount/#{foo}/otherSegment", MountedPageWithPlaceholder.class);
```

Java coding, initializing components:
´´´
add(new Link<Object>("mountedPageWithPlaceholder") {

			private static final long	serialVersionUID	= 1L;

			@Override
			public void onClick() {
				PageParameters parameters = new PageParameters();
				parameters.add("foo", "foo");
				setResponsePage(MountedPageWithPlaceholder.class, parameters);
			}

		});
´´´

- The result url is <Application path>/pageMount/foo/otherSegment
- Placeholder can be declared as optional using the '#' instead of '$' and in this case, if you don't inform the parameter, the result url is <Application path>/pageMount/otherSegment

#### Mounting a package

Wicket allows to mount all of the pages inside a package to a given path using the mountPackage(String path, Class<T> pageClass). This method will mount every page inside pageClass's package to the specified path.

The structure of package-mounted pages will be:
```
<Application path>/mountedPath/<PageClassName>[optional query string]
```

To mount all pages inside a package we must provide two things:
- The path that will be used to define a package;
- Just one class of that package;

So, in your WebApplication class you must add the following line:
```
mountPackage("/mountPackage", StatefulPackageMount.class);
```

The implementation of the mountPackage method mounts an instance of org.apache.wicket.request.mapper.PackageMapper to the given path.

#### Providing custom mapper context to request mappers
The Interface org.apache.wicket.request.mapper.IMapperContext is used by request mappers to create new page instances and to retrieve static URL segments used to build and parse page URLs. These segments are:
- Namespace. It's the first URL segment of non-mounted pages;
- Identifier for non-bookmarkable URLs. It's the segment that identifies no bookmarkable pages; 
- Identifier for bookmarkable URLs. It's is the segment that identifies bookmarkable pages;
- Identifier for resources. It's the segment that identifies Wicket resources.

To customize the default wicket's mapper strategy you should extends the class DefaultMapperContext and use it in your WicketApplication class:
```
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
```

#### Controlling how page parameters are encoded

The interface org.apache.wicket.request.mapper.parameter.IPageParametersEncoder exposes two methods: 
1. encodePageParameters() encodes page parameters into an URL;
2. decodePageParameters() extracts page parameters from the URL;

Wicket comes with a built-in implementation called org.apache.wicket.request.mapper.parameter.UrlPathPageParametersEncoder and it encodes named page parameters as URL segments using the following patter: /paramName1/paramValue1/paramName2 ...

To use it, mount your pages as the follows:
```
mount(new MountedMapper("/mountedPath", MountedPage.class, new UrlPathPageParametersEncoder()));
```

Remember that you can map a package as well:
```
mount(new PackageMapper(mountPath, packageName));
```

And you can create a link:
```
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
```

The result url will be:
```
<APPLICATION_PATH>/mountedPath/fooParam/fooValue/barParam/barValue
```

#### Encrypting Page URLs
URLs can expose too many details about the internal structure of our web application. To avoid this kind of security threat we can use the CryptoMapper which wraps an existing mapper and encrypts the original URL producing a single encrypted segment.

CryptoMapper might not be strong enough for production environment. So, just to see how things work, we will need to specify the CryptoMapper in WicketApplication class before all mount, mountPage and mountPackage declarations:
```
@Override
public void init() {
	super.init();
	setRootRequestMapper(new CryptoMapper(getRootRequestMapper(), this));
	
	// All mount declarations omitted
}

```
