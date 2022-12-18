package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.LoginPage;
import app.bersama.pages.MyAccountPage;
import app.bersama.pages.NavigationSectionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */
public class CommonStep {

    @Given("user navigate to login page")
    public void user_navigate_to_login_page() {
        NavigationSectionPage navigationSectionPage = new NavigationSectionPage(
                DriverManager.getInstance().getDriver());

        navigationSectionPage.tapNavigationAccount();

        MyAccountPage myAccountPage = new MyAccountPage(
                DriverManager.getInstance().getDriver());

        myAccountPage.tapButtonLogin();
    }

    @When("user login with valid email {string} and password {string}")
    public void user_login_with_valid_email_and_password(String email, String password) {

        LoginPage loginPage = new LoginPage(
                DriverManager.getInstance().getDriver());

        loginPage.modalLogin(email, password);


    }

    @Then("user should be able to login and verify email valid with email {string}")
    public void user_should_be_able_to_login_and_verify_email_valid_with_email(String validation) {
        LoginPage loginPage = new LoginPage(
                DriverManager.getInstance().getDriver());

        loginPage.assertLogin(validation);
    }
}
