package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    AndroidDriver appiumDriver;

    @FindBy(id = "citySpinner")
    private WebElement cityDropdown;

    @FindBy(id = "search_ET")
    private WebElement citySearchBox;



    @FindBy(id = "city_name")
    private WebElement cityName;

    @FindBy(xpath = "//android.widget.TextView[@text='Cars']")
    private WebElement carCategory;

    @FindBy(id = "sign_in_button")
    private WebElement googleButton;

    @FindBy(xpath = "//android.widget.Button[@text='Later']")
    private WebElement laterButton;

    @FindBy(id = "text1")
    private WebElement googleAccountRadioButton;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    private WebElement googleAccountProceedButton;

    @FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    private WebElement locationPermissionDenyButton;




    public HomePage(AndroidDriver appiumDriver) throws Exception {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void selectGoogleAccount() {
        waitForElementToBeVisible(googleAccountRadioButton);
        googleAccountRadioButton.click();
        googleAccountProceedButton.click();

    }

    public void denyLocationPermission(){
        locationPermissionDenyButton.click();
    }

    public void upgradeTheAppLater(){

        try{
            if( laterButton.isDisplayed())
                laterButton.click();
        }
        catch (Exception e)
        {
            //do nothing
        }
    }

    public void selectCity(String city) {
        cityDropdown.click();
        citySearchBox.click();
        citySearchBox.sendKeys(city);
        waitForElementToBeVisible( cityName);
        cityName.click();
    }

    public void selectCarCategory(){

        carCategory.click();
        waitForElementToBeVisible(carCategory);
        carCategory.click();

    }




}
