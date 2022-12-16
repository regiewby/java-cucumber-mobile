package app.bersama;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */
public class MobileFactory {


    private AppiumDriver appiumDriver;

    public AppiumDriver launchMobile(String platformType) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        URL url = new URL("http://localhost:4723/wd/hub");

        if (platformType.equalsIgnoreCase("ANDROID")) {
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
            dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID.toString());
            dc.setCapability(MobileCapabilityType.APP, "/Users/regiewby/git.server/java-cucumber-mobile/apk/app-second-hand.apk");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");

        } else if (platformType.equalsIgnoreCase("IOS")) {
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS.toString());
            dc.setCapability(MobileCapabilityType.APP, "apk/app-second-hand.apk");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
            dc.setCapability(MobileCapabilityType.UDID, "");
            dc.setCapability(MobileCapabilityType.NO_RESET, false);
        }
        appiumDriver = new AppiumDriver<MobileElement>(url,dc);

        return appiumDriver;
    }
}
