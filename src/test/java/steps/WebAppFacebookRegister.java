package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class WebAppFacebookRegister {
    AndroidDriver driver  ;
    @When("^I launch Quickr mobile web$")
    public void iLaunchQuickrMobileWeb() throws Throwable {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Nexus6");
        desiredCapabilities.setCapability("browserName","Chrome");
        desiredCapabilities.setCapability("platformName", "Android");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities) {
        };
         driver.get("http://quikr.com");
    }

    @And("^I choose to register$")
    public void iChooseToRegister() throws Throwable {
        driver.findElement(By.id("hamburger")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("hamLoginLink")).click();

    }

    @Then("^I should see an option to register using Facebook$")
    public void iShouldSeeAnOptionToRegisterUsingFacebook() throws Throwable {
        Thread.sleep(5*1000);
        driver.findElement(By.partialLinkText("Register")).click();
        Thread.sleep(2*1000);
        Assert.assertTrue(driver.findElement(By.className("icon-facebook")).isDisplayed());

    }

}
