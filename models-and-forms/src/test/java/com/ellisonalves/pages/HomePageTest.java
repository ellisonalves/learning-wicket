package com.ellisonalves.pages;

import com.ellisonalves.panels.LeftMenuPanel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class HomePageTest {

    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester();
        tester.startPage(HomePage.class);
    }

    @Test
    public void shouldRenderHomePageInItsInitialState() {
        //assert rendered page class
        tester.assertRenderedPage(HomePage.class);

        tester.assertComponent("leftMenuPanel", LeftMenuPanel.class);
    }
}
