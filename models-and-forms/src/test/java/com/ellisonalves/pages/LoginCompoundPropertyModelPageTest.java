package com.ellisonalves.pages;

import com.ellisonalves.WicketApplication;
import com.ellisonalves.panels.LoginFormPanel;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by enas on 29/08/2016.
 */
public class LoginCompoundPropertyModelPageTest {

    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
        tester.startPage(new LoginCompoundPropertyModelPage());
        tester.assertRenderedPage(LoginCompoundPropertyModelPage.class);
    }

    @Test
    public void shouldRenderInItsInitialState() {
        tester.assertComponent("loginFormPanel", LoginFormPanel.class);

        tester.assertEnabled("loginFormPanel:loginForm");
        tester.assertVisible("loginFormPanel:loginForm");

        tester.assertEnabled("loginFormPanel:loginForm:username");
        tester.assertVisible("loginFormPanel:loginForm:password");
    }

    @Test
    public void shouldReturnAnErrorWhenSubmitFormWithBlankValues() {
        FormTester formTester = tester.newFormTester("loginFormPanel:loginForm", true);
        formTester.submit();

        tester.assertErrorMessages(
                "'username' is required.",
                "'password' is required."
        );
    }

    @Test
    public void shouldReturnAnErrorMessageWhenValuesAreInvalid() {
        FormTester formTester = tester.newFormTester("loginFormPanel:loginForm");
        formTester.setValue("username", "Invalid user");
        formTester.setValue("password", "Invalid password");
        formTester.submit();

        tester.assertErrorMessages("Wrong username or password!");
    }

    @Test
    public void shouldSubmitSuccessfullyWhenFieldsAreValid() throws Exception {
        FormTester formTester = tester.newFormTester("loginFormPanel:loginForm");
        formTester.setValue("username", "test");
        formTester.setValue("password", "test");
        formTester.submit();

        tester.assertNoErrorMessage();
        tester.assertInfoMessages("User and pass are correct!");
    }

}