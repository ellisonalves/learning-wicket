package com.ellisonalves.pages;

import com.ellisonalves.LinkToPage;
import com.ellisonalves.panels.LeftMenuPanel;
import org.apache.wicket.markup.html.WebPage;

/**
 * Homepage
 */
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public HomePage() {
        add(new LeftMenuPanel("leftMenuPanel"));
    }

}
