package com.ellisonalves;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class PageWithParameters extends WebPage {

	private static final long	serialVersionUID	= 1L;

	public PageWithParameters(PageParameters parameters) {
		super(parameters);
	}
	
}
