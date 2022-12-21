package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.TestDataProvider;
import app.bersama.pages.LoginPage;
import app.bersama.pages.MyAccountPage;
import app.bersama.pages.NavigationSectionPage;
import app.bersama.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStep {

    String name = TestDataProvider.getRandomUserName();
    String email = TestDataProvider.getRandomEmail();
    String password = TestDataProvider.getRandomPasswordNumber();
    String phoneNo = TestDataProvider.getRandomPhoneNumber();
    String city = TestDataProvider.getRandomCity();
    String address = TestDataProvider.getRandomAddress();

    @Given("user navigate to register page")
    public void user_navigate_to_register_page() {
        NavigationSectionPage navigationSectionPage = new NavigationSectionPage(
                DriverManager.getInstance().getDriver());

        MyAccountPage myAccountPage = new MyAccountPage(
                DriverManager.getInstance().getDriver());

        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());

        navigationSectionPage.tapNavigationAccount();
        myAccountPage.tapButtonLogin();
        loginPage.tapButtonRegister();
    }
    @When("user entry data")
    public void user_entry_data() {
        RegisterPage registerPage = new RegisterPage(DriverManager.getInstance().getDriver());
        registerPage.enterData(name,email,password,phoneNo,city,address);
        registerPage.tapButtonRegister();
    }

    @Then("user successfully register new account")
    public void user_successfully_register_new_account() {
        MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getInstance().getDriver());
        myAccountPage.verifyLogin(name,phoneNo,email);
    }
}