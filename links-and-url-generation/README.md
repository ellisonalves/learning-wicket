## PageParameters
Wicket use PageParameters class to get named parameters passed through query strings (Url). Considering these parameters are name-value pairs, PageParameters offers methods like: ***add(String name, Object value)***, ***set(String name, Object value)***, ***remove(String name)***, ***get(String name)*** just as Map interface from Java.
We need to extends WebPage class and override its constructor with **WebPage(PageParameters pageParameters)**. That constructor will be used to build the page URL and it can be retrieved at a later time with **OurPageClass#getPageParameters()** method. Let´s see an example how we can use it:


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

The generated URL is **/wicket/bookmarkable/com.ellisonalves.PageWithParameters?foo=foo&bar=bar** and the reason is wicket will try to generate a static URL when a page is instatiated using a constructor with no argument or a constructor that accepts only a PageParameters. This is a bookmarkable URL and uses can copy and paste it.

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