package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage {

    public CheckOutPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<WebElement> ProductsList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public WebElement totalAmount;

    public List<WebElement> ProductsList() {
        System.out.println("Trying to get Product List");
        return ProductsList;
    }

    public WebElement totalAmount() {
        System.out.println("Trying to get Total Amount");
        return totalAmount;
    }
}
