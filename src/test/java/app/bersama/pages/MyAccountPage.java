package app.bersama.pages;

import app.bersama.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */
public class MyAccountPage {

    private AppiumDriver appiumDriver;

    public MyAccountPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    //asa@gmail.com
    //123123
    @FindBy(id = "id.binar.fp.secondhand:id/btn_login")
    private WebElement button_login;

    public void tapButtonLogin() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(button_login));
        button_login.click();
    }
}
