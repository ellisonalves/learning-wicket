package com.ellisonalves;

import org.apache.wicket.markup.html.link.Link;

/**
 * Just a shortcut to avoid creating inner classes.
 *
 * Created by enas on 29/08/2016.
 */
public class LinkToPage extends Link {

    private Class classRef;

    public LinkToPage(String id, Class classRef) {
        super(id);
        this.classRef = classRef;
    }

    @Override
    public void onClick() {
        setResponsePage(classRef);
    }

}
