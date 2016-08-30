package com.ellisonalves.panels;

import com.ellisonalves.WicketApplication;
import com.ellisonalves.pojo.Login;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LoginFormPanelTest {

    private WicketTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester(new WicketApplication());
    }

    @Test
    public void shouldTestTheInitialState() throws Exception {
        LoginFormPanel panel = tester.startComponentInPage(new LoginFormPanel("panel", Model.of(new Login())));

        tester.assertComponent("panel:loginStatus", FeedbackPanel.class);
        tester.assertComponent("panel:loginForm", Form.class);

        Component form = panel.get("loginForm");
        assertTrue(form.isVisible());

        RequiredTextField username = (RequiredTextField) panel.get("loginForm:username");
        assertNotNull(username.getValue());
        assertTrue(username.getValue().isEmpty());

        PasswordTextField password = (PasswordTextField) panel.get("loginForm:password");
        assertNotNull(password.getValue());
        assertTrue(password.getValue().isEmpty());
    }

}