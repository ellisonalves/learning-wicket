package com.ellisonalves.panels;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by enas on 29/08/2016.
 */
public class LeftMenuPanelTest {

    private WicketTester wicketTester;

    @Before
    public void setUp() throws Exception {
        wicketTester = new WicketTester();
    }

    @Test
    public void shouldPresentValidLinksWhenInItsInitialState() {
        LeftMenuPanel leftMenuPanel = wicketTester.startComponentInPage(LeftMenuPanel.class);

        assertNotNull(leftMenuPanel.get("gotoLoginFormPropertyModel"));
        assertNotNull(leftMenuPanel.get("gotoLoginFormCompoundPropertyModel"));
        assertNotNull(leftMenuPanel.get("gotoDropDownChoiceComponent"));
    }

}