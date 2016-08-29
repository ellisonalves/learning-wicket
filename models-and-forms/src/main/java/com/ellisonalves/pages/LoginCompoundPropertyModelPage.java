package com.ellisonalves.pages;

import com.ellisonalves.forms.LoginCompoundPropertyModelForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class LoginCompoundPropertyModelPage extends HomePage {

    public LoginCompoundPropertyModelPage() {
        add(new FeedbackPanel("loginStatus"));
        add(new LoginCompoundPropertyModelForm("loginForm"));
    }

}
