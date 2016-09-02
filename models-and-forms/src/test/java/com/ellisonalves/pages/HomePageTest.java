package com.ellisonalves.pages;

import com.ellisonalves.WicketApplication;
import com.ellisonalves.panels.LeftMenuPanel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class HomePageTest {

    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
        tester.startPage(HomePage.class);
    }

    @Test
    public void shouldRenderHomePageInItsInitialState() {
        //assert rendered page class
        tester.assertRenderedPage(HomePage.class);
        tester.assertComponent("leftMenuPanel", LeftMenuPanel.class);
    }

    @Test
    public void shouldRenderLoginPropertyModelPageWhenOnClick() throws Exception {
        tester.clickLink("leftMenuPanel:gotoLoginFormPropertyModel");
        tester.assertRenderedPage(LoginPropertyModelPage.class);
    }

    @Test
    public void shouldRenderLoginCompoundPropertyModelPageWhenOnClick() throws Exception {
        tester.clickLink("leftMenuPanel:gotoLoginFormCompoundPropertyModel");
        tester.assertRenderedPage(LoginCompoundPropertyModelPage.class);
    }

    @Test
    public void shouldRenderDropDownChoicePageWhenOnClick() throws Exception {
        tester.clickLink("leftMenuPanel:gotoDropDownChoiceComponent");
        tester.assertRenderedPage(DropDownChoicePage.class);
    }

    @Test
    public void shouldRenderModelChainingPageWhenOnClick() throws Exception {
        tester.clickLink("leftMenuPanel:gotoModelChaining");
        tester.assertRenderedPage(ModelChainingPage.class);
    }

    @Test
    public void shouldRenderFormInDetailsWhenOnClick() throws Exception {
        tester.clickLink("leftMenuPanel:gotoFormInDetails");
        tester.assertRenderedPage(FormInDetailsPage.class);
    }

}
