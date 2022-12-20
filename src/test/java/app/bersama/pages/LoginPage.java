package app.bersama.pages;

import app.bersama.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private AppiumDriver appiumDriver;

    public LoginPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(navLinkDaftar));
        navLinkDaftar.click();
    }

    public void modalLogin(String email, String password) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(email);

        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.sendKeys(password);

        wait.until(ExpectedConditions.visibilityOf(btnLogin));
        btnLogin.click();
    }

    public void assertLogin(){
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(assertLogin));
        assertLogin.isDisplayed();
    }

}
