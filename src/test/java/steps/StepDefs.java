package steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import pages.*;

import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class StepDefs extends BaseSteps {

    @When("I launch Quikr app")
    public void iLaunchQuikrApp() throws Throwable {

        driver.findElement(By.id("login_register_view")).isDisplayed();

    }

    @And("I choose to log in")
    public void iChooseToLogIn() throws Throwable {

        driver.findElement(By.id("sign_in_button")).click();

    }

    @Then("I see account picker screen with my email address \"([^\"]*)\"")
    public void iSeeAccountPickkerScreenWithMyEmailAddress(String expected) throws Throwable {
        Thread.sleep(5000);
        Assert.assertEquals("Email ID matches",expected,driver.findElement(By.id("com.google.android.gms:id/account_name")).getText());
    }


    @And("^I choose \"([^\"]*)\" as my city$")
    public void iChooseAsMyCity(String city) throws Throwable {


        new LandingPage(driver).skipToHomePage();
        //new HomePage(driver).selectGoogleAccount();
        //new HomePage(driver).denyLocationPermission();
        new HomePage(driver).upgradeTheAppLater();
        new HomePage(driver).selectCity(city);
    }

    @And("^I search for \"([^\"]*)\" under Used Cars$")
    public void iSearchForUnderUsedCars(String carName) throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver,10);
        new HomePage(driver).selectCarCategory();
        new CarSearchPage(driver).inputCarName(carName);
        new ProductSearchInputPage(driver).ClickOnSearch();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.ImageView"))).click();
        driver.findElement(By.className("android.widget.ImageView")).click();
    }

    @Then("^I should see the first car search result with \"([^\"]*)\"$")
    public void iShouldSeeTheFirstCarSearchResultWith(String carBrand) throws Throwable {

        driver.findElement(By.className("android.widget.ImageButton")).click();
        new SearchResultsPage(driver).VerifyFirstResultIsAsExpected(carBrand);
        //new SearchResultsPage(driver).SelectFirstAdd();
    }


    @And("^I select the first add available$")
    public void iSelectTheFirstAddAvailable() throws Throwable {
        driver.findElement(By.className("android.widget.ImageButton")).click();
        new SearchResultsPage(driver).SelectFirstAdd();
    }

    @And("^I click on the Images available$")
    public void iClickOnTheImagesAvailable() throws Throwable {
        driver.findElement(By.id("dialog_overlay_layout")).click();
        new ProductAdPage(driver).ClickOnProductImage();

    }



    @Then("^I swipe to the second Image$")
    public void iSwipeToTheSecondImage() throws Throwable {
        new BasePage(driver).swipeToLeft();
    }
}
