package app.bersama.pages;

import app.bersama.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */
public class MyAccountPage {

    private final AppiumDriver appiumDriver;

    public MyAccountPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id.binar.fp.secondhand:id/btn_login")
    private WebElement button_login;

    @FindBy(id = "id.binar.fp.secondhand:id/iv_profile")
    private WebElement profile_picture;

    public void tapButtonLogin() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(button_login));
        button_login.click();
    }

    public void verifyLogin() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(profile_picture));
        Assert.assertTrue(profile_picture.isDisplayed());
    }

    public boolean verifyLoginAndAssert() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(profile_picture));
        return profile_picture.isDisplayed();
    }
}
