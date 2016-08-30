package com.ellisonalves.pages;

import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by enas on 29/08/2016.
 */
public class LoginPropertyModelPageTest {

    private WicketTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester();
        tester.startPage(LoginPropertyModelPage.class);
        tester.assertRenderedPage(LoginPropertyModelPage.class);
    }

    @Test
    public void shouldRenderInItsInitialState() {
        tester.assertEnabled("loginForm");
        tester.assertEnabled("loginForm:username");

        tester.assertVisible("loginForm");
        tester.assertVisible("loginForm:password");
    }

    @Test
    public void shouldReturnAnErrorWhenSubmitFormWithBlankValues() {
        FormTester formTester = tester.newFormTester("loginForm", true);
        formTester.submit();

        tester.assertErrorMessages(
                "'username' is required.",
                "'password' is required."
        );
    }

    @Test
    public void shouldReturnAnErrorMessageWhenValuesAreInvalid() {
        FormTester formTester = tester.newFormTester("loginForm");
        formTester.setValue("username", "Invalid user");
        formTester.setValue("password", "Invalid password");
        formTester.submit();

        tester.assertErrorMessages("Wrong username or password!");
    }

    @Test
    public void shouldSubmitSuccessfullyWhenFieldsAreValid() throws Exception {
        FormTester formTester = tester.newFormTester("loginForm");
        formTester.setValue("username", "test");
        formTester.setValue("password", "test");
        formTester.submit();

        tester.assertNoErrorMessage();
        tester.assertInfoMessages("User and pass are correct!");
    }

}