package app.bersama;

import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TestDataProvider {

    private static final Faker faker = new Faker();

    public static String getRandomUserName() {
        return faker.name().firstName();
    }

    public static String getRandomPasswordNumber() {
        return getRandomStringMatchingPattern("[A-Z]\\d{8}");
    }

    public static String getRandomPhoneNumber() {
        return "08" + getRandomNumber(11);
    }

    public static String getRandomStringMatchingPattern(String pattern) {
        return faker.regexify(pattern);
    }

    public static String getRandomCity() {
        return faker.address().city();
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomNumber(int digits) {
        return faker.number().digits(digits);
    }

    public static String getRandomEmail() {
        return getRandomStringMatchingPattern("random\\d{8}") + ".user-binar@test.binar.com";
    }
}
