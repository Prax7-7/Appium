package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarSearchPage extends BasePage {

    AndroidDriver appiumDriver;

    @FindBy(id = "cnb_hp_choose_et")
    private  WebElement carSearchBox;

    @FindBy(id = "cnb_search_text_et")
    private  WebElement carSearchTextBox;

    @FindBy(id = "text1")
    private List<WebElement> carsList;

    @FindBy(id = "text1")
    private WebElement sampleCarInCarList;




    public CarSearchPage(AndroidDriver appiumDriver) throws Exception{
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void inputCarName(String carName) {
        carSearchBox.click();
        carSearchTextBox.sendKeys(carName);
      WebElement productFound =  findAndSelect(carsList, sampleCarInCarList, carName);

      if(productFound!=null)
      {
          productFound.click();
      }
    }

    protected WebElement findAndSelect(List<WebElement> list, WebElement element , String name){
        waitForElementToBeVisible(element);
        element.click();

        for(WebElement result : list){
            if(result.getText().contains(name));
            {



                return result;
            }
        }

        return  null;
    }

}
