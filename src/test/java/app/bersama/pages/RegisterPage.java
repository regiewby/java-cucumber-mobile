package app.bersama.pages;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegisterPage {

    private AppiumDriver appiumDriver;

    public RegisterPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "id.binar.fp.secondhand:id/et_name")
    private WebElement txtFullname;

    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout//../android.widget.ScrollView[1]/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    private  WebElement txtEmail;

    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout//../android.widget.ScrollView[1]/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText")
    private WebElement txtPassword;

    @FindBy (id = "id.binar.fp.secondhand:id/et_phone")
    private WebElement txtPhoneNumber;

    @FindBy (id = "id.binar.fp.secondhand:id/et_city")
    private WebElement txtCity;

    @FindBy (id = "id.binar.fp.secondhand:id/et_address")
    private WebElement txtAddress;

    @FindBy (id = "id.binar.fp.secondhand:id/btn_register")
    private WebElement btnRegister;

    public void validRegister (String fullName, String email, String password, String phoneNumber, String city, String address){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);

        Keyword.waitUntilElementIsVisible(txtFullname);
        txtFullname.sendKeys(fullName);

        Keyword.waitUntilElementIsVisible(txtEmail);
        txtEmail.sendKeys(email);

        Keyword.waitUntilElementIsVisible(txtPassword);
        txtPassword.sendKeys(password);

        Keyword.waitUntilElementIsVisible(txtPhoneNumber);
        txtPhoneNumber.sendKeys(phoneNumber);

        Keyword.waitUntilElementIsVisible(txtCity);
        txtCity.sendKeys(city);

        Keyword.waitUntilElementIsVisible(txtAddress);
        txtAddress.sendKeys(address);

        Keyword.swipeByElement(txtCity,txtFullname);

        Keyword.waitUntilElementIsVisible(btnRegister);
        btnRegister.click();
    }
}
