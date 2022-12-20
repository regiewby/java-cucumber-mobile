package app.bersama.pages;

import app.bersama.Keyword;
import io.appium.java_client.AppiumDriver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class RegisterPage {

    private final AppiumDriver appiumDriver;

    public RegisterPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id.binar.fp.secondhand:id/et_name")
    private WebElement entry_name;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView[1]/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    private WebElement entry_email;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView[1]/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText")
    private WebElement entry_password;

    @FindBy(id = "id.binar.fp.secondhand:id/et_phone")
    private WebElement entry_phoneNo;

    @FindBy(id ="id.binar.fp.secondhand:id/et_city")
    private WebElement entry_city;

    @FindBy(id = "id.binar.fp.secondhand:id/et_address")
    private WebElement entry_address;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_register")
    private WebElement button_register;

    public void enterData(String Name, String Email, String Password, String PhoneNo, String City, String Address){
        entry_name.sendKeys(Name);
        entry_email.sendKeys(Email);
        entry_password.sendKeys(Password);
        entry_phoneNo.sendKeys(PhoneNo);
        entry_city.sendKeys(City);
        Keyword.swipeByElement(entry_city,entry_name);
        entry_address.sendKeys(Address);
    }
    public void tapButtonRegister(){
        button_register.click();
    }
}
