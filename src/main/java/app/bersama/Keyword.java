package app.bersama;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class Keyword {

    private static final AppiumDriver driver = DriverManager.getInstance().getDriver();

    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void pullToRefresh() {
        int deviceWidth = driver.manage().window().getSize().getWidth();
        int deviceHeight = driver.manage().window().getSize().getHeight();
        int midX = (deviceWidth / 2);
        int midY = (deviceHeight / 2);
        int bottomEdge = (int) (deviceHeight * 0.85f);
        new TouchAction(driver)
                .press(PointOption.point(midX,midY))
                .waitAction(waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(midX, bottomEdge))
                .release().perform();
    }

    public static void swipeByElement(WebElement startElement, WebElement endElement) {

        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
        new TouchAction(DriverManager.getInstance().getDriver())
                .press(PointOption.point(startX, startY))
                .waitAction(waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
}
