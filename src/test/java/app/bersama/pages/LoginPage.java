package app.bersama.pages;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    private AppiumDriver appiumDriver;

    public LoginPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    //asa@gmail.com
    //123123


    @FindBy (id = "id.binar.fp.secondhand:id/et_email")
    private WebElement txtEmail;

    @FindBy (id = "id.binar.fp.secondhand:id/et_password")
    private WebElement txtPassword;

    @FindBy (id = "id.binar.fp.secondhand:id/btn_login")
    private WebElement btnLogin;

    @FindBy (id = "id.binar.fp.secondhand:id/iv_profile")
    private WebElement assertLogin;

    @FindBy (id = "id.binar.fp.secondhand:id/tv_register")
    private WebElement navLinkDaftar;

    public void tapNavLinkRegister(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        Keyword.waitUntilElementIsVisible(navLinkDaftar);
        navLinkDaftar.click();
    }

    public void modalLogin(String email, String password) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        Keyword.waitUntilElementIsVisible(txtEmail);
        txtEmail.sendKeys(email);

        Keyword.waitUntilElementIsVisible(txtPassword);
        txtPassword.sendKeys(password);

        Keyword.waitUntilElementIsVisible(btnLogin);
        btnLogin.click();
    }

    public void assertLogin(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        Keyword.waitUntilElementIsVisible(assertLogin);
        assertLogin.isDisplayed();
    }

}
