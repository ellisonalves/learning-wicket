package com.ellisonalves.panels;

import com.ellisonalves.LinkToPage;
import com.ellisonalves.pages.*;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by enas on 29/08/2016.
 */
public class LeftMenuPanel extends Panel {

    public LeftMenuPanel(String id) {
        super(id);

        add(new LinkToPage("gotoLoginFormPropertyModel", LoginPropertyModelPage.class));
        add(new LinkToPage("gotoLoginFormCompoundPropertyModel", LoginCompoundPropertyModelPage.class));
        add(new LinkToPage("gotoDropDownChoiceComponent", DropDownChoicePage.class));
        add(new LinkToPage("gotoModelChaining", ModelChainingPage.class));
        add(new LinkToPage("gotoFormInDetails", FormInDetailsPage.class));
    }

}
