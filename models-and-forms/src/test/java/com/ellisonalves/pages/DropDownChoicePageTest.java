package com.ellisonalves.pages;

import com.ellisonalves.WicketApplication;
import com.ellisonalves.panels.DropDownChoicePanel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by enas on 30/08/2016.
 */
public class DropDownChoicePageTest {

    private WicketTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester(new WicketApplication());
        tester.startPage(DropDownChoicePage.class);
        tester.assertRenderedPage(DropDownChoicePage.class);
    }

    @Test
    public void checkIfPageAreIncludingItsNestedComponentesCorrectly() throws Exception {
        tester.assertComponent("choicePanel", DropDownChoicePanel.class);
    }

}