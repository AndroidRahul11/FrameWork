package MobileAuto.MavenJava;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NativeBase {
    public static AppiumDriverLocalService service;

    public static AppiumDriverLocalService appiumStartNative() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        return service;
    }

    public static void startEmulatpr() throws IOException, InterruptedException {//run emulator via code
        Runtime.getRuntime().exec("C:\\Users\\rvyavahare\\Pictures\\Automation\\Mavenjava\\FrameWork\\resources\\startEmulator.bat");
        Thread.sleep(8000);
    }

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

        File appDir = new File("Resources");
        File app = new File(appDir, "ApiDemos-debug.apk");
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "rahulEmu");
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "73268627");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;


    }

}

