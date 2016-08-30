package com.ellisonalves.pages;

import com.ellisonalves.panels.LoginFormPanel;
import com.ellisonalves.pojo.Login;
import org.apache.wicket.model.Model;

public class LoginCompoundPropertyModelPage extends HomePage {

    public LoginCompoundPropertyModelPage() {
        add(new LoginFormPanel("loginFormPanel", Model.of(new Login())));
    }

}
