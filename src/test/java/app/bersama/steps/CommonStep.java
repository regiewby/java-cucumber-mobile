package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import app.bersama.enums.Direction;
import app.bersama.pages.LoginPage;
import app.bersama.pages.MyAccountPage;
import app.bersama.pages.NavigationSectionPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */
public class CommonStep {

    private final AndroidDriver androidDriver;

    public CommonStep() {
        androidDriver = DriverManager.getInstance().getDriver();
    }

    @Given("user navigate to login page")
    public void user_navigate_to_login_page() {

        // click button account navigation
        NavigationSectionPage navigationSectionPage = new NavigationSectionPage(androidDriver);
        navigationSectionPage.tapNavigationAccount();

        // click button login
        MyAccountPage myAccountPage = new MyAccountPage(androidDriver);
        myAccountPage.tapButtonLogin();
    }

    @When("user login with username {string} and password {string}")
    public void userLoginWithUsernameAndPassword(String email, String password) {
        LoginPage loginPage = new LoginPage(androidDriver);
        loginPage.userLogin(email,password);
    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        MyAccountPage myAccountPage = new MyAccountPage(androidDriver);
        Assert.assertTrue(myAccountPage.verifyLoginAndAssert());
    }
}
