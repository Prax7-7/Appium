package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
private AndroidDriver driver;
    private WebDriverWait wait;



    public BasePage(AndroidDriver driver) throws Exception {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);

    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void swipeToLeft()
    {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        TouchAction swipeAction = new TouchAction(driver).press(height/2,width).moveTo(height/2,width/3).release().perform();
    }


}
