package app.bersama.pages;

import app.bersama.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */
public class LoginPage {

    private AppiumDriver appiumDriver;

    public LoginPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id.binar.fp.secondhand:id/et_email")
    private WebElement input_email;

    @FindBy(id = "id.binar.fp.secondhand:id/et_password")
    private WebElement input_password;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_login")
    private WebElement button_login;

    public void userLogin(String email, String password) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(input_email));
        input_email.sendKeys(email);
        input_password.sendKeys(password);
        button_login.click();
    }
}
