package app.bersama;

import io.appium.java_client.AppiumDriver;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */
public class DriverManager {

    private static final DriverManager instance = new DriverManager();

    ThreadLocal<AppiumDriver> mobileDriver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        return instance;
    }

    public AppiumDriver getDriver() {
        return mobileDriver.get();
    }

    public void setDriver(AppiumDriver appiumDriver) {
        mobileDriver.set(appiumDriver);
    }

    public void closeDriver() {
        mobileDriver.remove();
    }
}
