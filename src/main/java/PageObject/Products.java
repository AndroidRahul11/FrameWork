package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Products {
    public Products(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
    public WebElement AddToKart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart1")
    public WebElement KartIcon;

    public WebElement AddToKart() {
        System.out.println("Product added into Kart");
        return AddToKart;
    }

    public WebElement KartIcon() {
        System.out.println("Clicking Kart Icon to Checkout");
        return KartIcon;
    }
}


