package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ProductAdPage extends BasePage {
    AndroidDriver driver;

    public ProductAdPage(AndroidDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
    }


    @FindBy(className = "android.widget.ImageView")
    WebElement ProductImageView;

    @FindBy(id = "imgView")
    WebElement ProductImage;

    public void ClickOnProductImage()
    {
        //waitForElementToBeVisible(ProductImageView);
        //ProductImageView.click();
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        TouchAction click = new TouchAction(driver).press(height/3,width/2).release().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


}
