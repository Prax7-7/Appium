package pages;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage extends BasePage{
    AndroidDriver appiumDriver;

    @FindBy(id = "cars_ad_list_title_tv")
    private List<WebElement> carAdsList;

    public SearchResultsPage(AndroidDriver appiumDriver) throws Exception {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
        
    }

    public void VerifyFirstResultIsAsExpected(String searchText){
        Assert.assertTrue("Verified first result contains Honda",carAdsList.get(0).getText().startsWith(searchText));
    }

    public void SelectFirstAdd()
    {
        carAdsList.get(0).click();
    }


}
