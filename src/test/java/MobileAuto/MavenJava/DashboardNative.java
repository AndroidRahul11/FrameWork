package MobileAuto.MavenJava;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DashboardNative extends NativeBase {

    public static void main(String[] args) throws MalformedURLException {
        service = appiumStartNative();
        AndroidDriver<AndroidElement> driver = capabilities();
        System.out.println("App Launched Successfully!");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //driver.findElementByAndroidUIAutomator("(attribute("values")").click();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        System.out.println("Clicked on Views");
        System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
        service.stop();
    }
}
