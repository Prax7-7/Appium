package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchInputPage extends BasePage {

    AndroidDriver appiumDriver;


    @FindBy(id = "cnb_search_button")
    private WebElement searchProduct;

    public ProductSearchInputPage(AndroidDriver appiumDriver) throws Exception{
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void ClickOnSearch()
    {
        searchProduct.click();
    }

}
