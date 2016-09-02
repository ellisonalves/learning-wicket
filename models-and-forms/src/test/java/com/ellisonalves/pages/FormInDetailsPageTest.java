package com.ellisonalves.pages;

import com.ellisonalves.WicketApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by enas on 02/09/2016.
 */
public class FormInDetailsPageTest {

    private WicketTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester(new WicketApplication());
        tester.startPage(FormInDetailsPage.class);
        tester.assertRenderedPage(FormInDetailsPage.class);
    }

    @Test
    public void shouldTestSomething() throws Exception {
        fail("should test something ...");
    }
}