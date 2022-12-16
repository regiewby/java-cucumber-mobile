package app.bersama.steps;

import app.bersama.DriverManager;
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

        MyAccountPage myAccountPage = new MyAccountPage(
                DriverManager.getInstance().getDriver());

        navigationSectionPage.tapNavigationAccount();
        myAccountPage.tapButtonLogin();
    }
}
