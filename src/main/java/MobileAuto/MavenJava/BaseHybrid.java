package MobileAuto.MavenJava;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseHybrid {
    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;

    public AppiumDriverLocalService appiumStart() //run Appium server via code
    {
        boolean flag = checkIfServerIsRunning(4723);
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static boolean checkIfServerIsRunning(int port) {
        boolean isServerRunnig = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();

        } catch (IOException e) {
            isServerRunnig = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunnig;
    }

    public static void startEmulator() throws IOException, InterruptedException {//run emulator via code

        Runtime.getRuntime().exec("C:\\Users\\rvyavahare\\Pictures\\Automation\\Mavenjava\\FrameWork\\resources\\startEmulator.bat");
        Thread.sleep(20000);
    }

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException { //base capabilities
        File appDir = new File("Resources");
        File app = new File(appDir, "General-Store.apk");
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "rahulEmu");
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "73268627");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public static void getScreenshot(String s) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(scrFile, new File(System.getProperty("C:\\Users\\rvyavahare\\Pictures\\Automation\\Mavenjava\\FrameWork\\resources\\")+"\\"+s+".png"));
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));
    }
}
