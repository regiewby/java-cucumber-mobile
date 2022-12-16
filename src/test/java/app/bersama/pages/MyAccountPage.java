package app.bersama.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {





    @FindBy(id = "id.binar.fp.secondhand:id/btn_login")
    private WebElement button_entry;

    @FindBy (id = "id.binar.fp.secondhand:id/et_email")
    private WebElement entry_email;

    @FindBy (id = "id.binar.fp.secondhand:id/et_password")
    private WebElement entry_password;

    @FindBy (id = "id.binar.fp.secondhand:id/btn_login")
    private WebElement button_entry2;


}
