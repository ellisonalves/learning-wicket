package com.mycompany;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestMainTemplate
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void mainTemplateRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(MainTemplate.class);

		//assert rendered page class
		tester.assertRenderedPage(MainTemplate.class);
	}
}
