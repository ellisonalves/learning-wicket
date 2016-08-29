package com.ellisonalves;

import com.ellisonalves.pages.HomePage;
import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {

    /**
     * @see Application#getHomePage()
     */
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.protocol.http.WebApplication#init()
     */
    @Override
    protected void init() {
        super.init();
    }

}
