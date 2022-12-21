package app.bersama;

import app.bersama.enums.Direction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * @author regiewby on 20/12/22
 * @project java-cucumber-mobile
 */
public class Keyword {

    public static void swipeByElement(WebElement startElement, WebElement endElement) {

        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(DriverManager.getInstance().getDriver())
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    public static void swipeScreen(Direction dir) {

        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms
        int edgeBorder = 10; // better avoid edges

        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = DriverManager.getInstance().getDriver().manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        pointOptionEnd = switch (dir) {
            case DOWN -> // center of footer
                    PointOption.point(dims.width / 2, dims.height - edgeBorder);
            case UP -> // center of header
                    PointOption.point(dims.width / 2, edgeBorder);
            case LEFT -> // center of left side
                    PointOption.point(edgeBorder, dims.height / 2);
            case RIGHT -> // center of right side
                    PointOption.point(dims.width - edgeBorder, dims.height / 2);
            default -> throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        };

        // execute swipe using TouchAction
        try {
            new TouchAction(DriverManager.getInstance().getDriver())
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
