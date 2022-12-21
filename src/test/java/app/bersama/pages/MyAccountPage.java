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

public class  MyAccountPage {

    private AppiumDriver appiumDriver;

    public MyAccountPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "id.binar.fp.secondhand:id/btn_login")
    private WebElement button_login;

    @FindBy(id = "id.binar.fp.secondhand:id/tv_name")
    private WebElement label_name;

    @FindBy (id = "id.binar.fp.secondhand:id/tv_phone")
    private WebElement label_phoneNo;

    @FindBy (id="id.binar.fp.secondhand:id/tv_email")
    private WebElement label_email;

    public void tapButtonLogin() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(button_login));
        button_login.click();
    }

    public void verifyLogin(String expectedName, String expectedPhone, String expectedEmail) {
        Keyword.pullToRefresh();
        Keyword.waitUntilElementIsVisible(label_email);
        Assert.assertEquals(label_name.getText(), expectedName);
        Assert.assertEquals(label_phoneNo.getText(), expectedPhone);
        Assert.assertEquals(label_email.getText(), expectedEmail);
    }
}