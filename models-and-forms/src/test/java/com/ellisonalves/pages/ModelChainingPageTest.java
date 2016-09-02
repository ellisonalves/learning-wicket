package com.ellisonalves.pages;

import com.ellisonalves.WicketApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by enas on 01/09/2016.
 */
public class ModelChainingPageTest {

    private WicketTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester(new WicketApplication());
        tester.startPage(new ModelChainingPage());
    }

    @Test
    public void shouldCreateThePage() throws Exception {
        tester.assertRenderedPage(ModelChainingPage.class);
    }
}
