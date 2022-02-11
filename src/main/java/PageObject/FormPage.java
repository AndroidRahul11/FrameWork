package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement Name;

    @AndroidFindBy(xpath = "//*[@text='Female']")
    public WebElement FemaleOption;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement CountrySelection;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement LetsShop;

    public WebElement getName() {
        System.out.println("Trying to find Name Field");
        return Name;
    }

    public WebElement getCountrySelection() {
        System.out.println("Selecting a Item from Dropdown");
        return CountrySelection;
    }
}
