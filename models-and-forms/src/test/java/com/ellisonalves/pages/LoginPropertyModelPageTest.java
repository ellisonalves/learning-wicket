package com.ellisonalves.pages;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by enas on 29/08/2016.
 */
public class LoginPropertyModelPageTest {

    private WicketTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester();
    }

    @Test
    public void shouldRenderPageSuccessfully() {
        tester.startPage(LoginPropertyModelPage.class);
        tester.assertRenderedPage(LoginPropertyModelPage.class);
    }

}