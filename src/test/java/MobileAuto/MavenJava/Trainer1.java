package MobileAuto.MavenJava;

import PageObject.CheckOutPage;
import PageObject.FormPage;
import PageObject.Products;
import Utility.Utilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;


public class Trainer1 extends BaseHybrid {

    @Test
    public void toatlValidation() throws MalformedURLException, InterruptedException {
        service = appiumStart();
        //public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FormPage formpage = new FormPage(driver);
        //formpage.Name.sendKeys("RahulV"); //PageObject
        formpage.getName().sendKeys("RahulV");
        //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello"); //HArdcoded values

        driver.hideKeyboard();
        formpage.FemaleOption.click();
        //driver.findElement(By.xpath("//*[@text='Female']")).click();

        //formpage.CountrySelection.click();
        formpage.getCountrySelection().click();
        //driver.findElement(By.id("android:id/text1")).click();
        Utilities U = new Utilities(driver);
        U.scrollToText("Argentina");
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        //driver.findElement(MobileBy.AndroidUIAutoma tor("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
        driver.findElement(By.xpath("//*[@text='Argentina']")).click();

        formpage.LetsShop.click();
        //driver.findElement(By.id("com.androidsamp le.generalstore:id/btnLetsShop")).click();

        Products products = new Products(driver);
        products.AddToKart().click();
        //driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        //driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        products.KartIcon().click();
        //driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(4000);

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum = 0;

        CheckOutPage CheckPage = new CheckOutPage(driver);
        for (int i = 0; i < count; i++) {
            String amount1 = CheckPage.ProductsList.get(i).getText();
            //String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;//280.97+116.97
        }
        System.out.println(sum + "sum of products");
        String total = CheckPage.totalAmount.getText();
        //String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

        total = total.substring(1);
        double totalValue = Double.parseDouble(total);
        System.out.println(totalValue + "Total value of products");
        Assert.assertEquals(sum, totalValue);
//Mobile Gestures
        WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction t = new TouchAction(driver);
        t.tap(tapOptions().withElement(element(checkbox))).perform();
        WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
        t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        //service.stop();
    }

    public static double getAmount(String value) {
        value = value.substring(1);
        double amount2value = Double.parseDouble(value);
        return amount2value;
    }

}


