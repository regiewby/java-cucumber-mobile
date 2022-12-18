package app.bersama.pages;

import app.bersama.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private AppiumDriver appiumDriver;

    public RegisterPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(txtFullname));
        txtFullname.sendKeys(fullName);

        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(email);

        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.sendKeys(password);

        wait.until(ExpectedConditions.visibilityOf(txtPhoneNumber));
        txtPhoneNumber.sendKeys(phoneNumber);

        wait.until(ExpectedConditions.visibilityOf(txtCity));
        txtCity.sendKeys(city);

        wait.until(ExpectedConditions.visibilityOf(txtAddress));
        txtAddress.sendKeys(address);

        wait.until(ExpectedConditions.visibilityOf(btnRegister));
        btnRegister.click();
    }
}
