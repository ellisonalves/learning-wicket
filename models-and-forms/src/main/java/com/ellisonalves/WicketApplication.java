package com.ellisonalves;

import com.ellisonalves.pages.HomePage;
import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.wicketstuff.pageserializer.fast2.Fast2WicketSerializer;

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

        // Optmizing Wicket serialization performance
        getFrameworkSettings().setSerializer(new Fast2WicketSerializer());

        mountPackage("/pages/", HomePage.class);

    }

}
