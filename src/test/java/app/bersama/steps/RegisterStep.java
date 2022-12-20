package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.TestDataProvider;
import app.bersama.pages.LoginPage;
import app.bersama.pages.MyAccountPage;
import app.bersama.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStep {
    String fullName = TestDataProvider.getRandomUserName();
    String email = TestDataProvider.getRandomEmail();
    String password = TestDataProvider.getRandomPasswordNumber();
    String phoneNumber = TestDataProvider.getRandomPhoneNumber();
    String city = TestDataProvider.getRandomCity();
    String address = TestDataProvider.getRandomAddress();

    @Given("user click button daftar to register new account")
    public void user_click_button_daftar_to_register_new_account() {
        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.tapNavLinkRegister();
    }
    @Given("user input valid data with")
    public void user_input_valid_data_with() {
        RegisterPage registerPage = new RegisterPage(DriverManager.getInstance().getDriver());
        registerPage.validRegister(fullName, email, password, phoneNumber, city, address);
    }

    @When("user click button daftar")
    public void user_click_button_daftar() {

    }
}
