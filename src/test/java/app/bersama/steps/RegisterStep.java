package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.LoginPage;
import app.bersama.pages.MyAccountPage;
import app.bersama.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RegisterStep {
    @Given("user click button daftar to register new account")
    public void user_click_button_daftar_to_register_new_account() {
        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.tapNavLinkRegister();
    }

    @Given("user input valid data with {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_input_valid_data_with(String fullName, String email, String password, String phoneNumber, String city, String address) {
        RegisterPage registerPage = new RegisterPage(DriverManager.getInstance().getDriver());
        registerPage.validRegister(fullName, email, password, phoneNumber, city, address);
    }

    @When("user click button daftar")
    public void user_click_button_daftar() {


    }
}
