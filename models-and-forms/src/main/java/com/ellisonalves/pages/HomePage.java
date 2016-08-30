package com.ellisonalves.pages;

import com.ellisonalves.panels.LeftMenuPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Homepage
 */
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public HomePage() {
        add(new LeftMenuPanel("leftMenuPanel"));
    }

    public HomePage(IModel<?> model) {
        super(model);
    }

    public HomePage(PageParameters parameters) {
        super(parameters);
    }

}
