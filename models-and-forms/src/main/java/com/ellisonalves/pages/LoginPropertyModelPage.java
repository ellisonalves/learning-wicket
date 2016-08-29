package com.ellisonalves.pages;

import com.ellisonalves.forms.LoginPropertyModelForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class LoginPropertyModelPage extends HomePage {

    private static final long serialVersionUID = 1L;

    public LoginPropertyModelPage() {
        add(new FeedbackPanel("loginStatus"));
        add(new LoginPropertyModelForm("loginForm"));
    }

}
