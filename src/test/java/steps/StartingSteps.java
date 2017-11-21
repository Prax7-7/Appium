package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ADBLogGeneration;

import java.io.*;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StartingSteps extends BaseSteps{

    private AppiumDriverLocalService appiumService;
    private ADBLogGeneration adbLogGeneration; // To Generate ADBLogs
    private ExecutorService executorService; // Start a Thread to generate ADBLogs


    @Before
    public void startAppium () throws Exception
    {
        int port = 4723;
         //appiumService = AppiumDriverLocalService.buildDefaultService();
         appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
        .usingDriverExecutable(new File("/usr/local/bin/node"))
        .withAppiumJS(new File ("/usr/local/bin/appium"))
        .withIPAddress("0.0.0.0")
        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
        .withLogFile(new File("build/appium.log")));
        appiumService.start();
        //CaptureLogs captureLogs = new CaptureLogs();
        //captureLogs.start();

        adbLogGeneration = new ADBLogGeneration(); // To Generate ADBLogs
        generateADBLog();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Nexus_6_API_23");
        desiredCapabilities.setCapability("app", "/Users/prashanthsiddharamaiah/Development/HelloAppium/app/quikr.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("noReset",false);
        desiredCapabilities.setCapability("fullReset",true);
        desiredCapabilities.setCapability("platformVersion","5.1");
        desiredCapabilities.setCapability("newCommandTimeout",120);
        //desiredCapabilities.setCapability("appPackage","com.quikr");
        //desiredCapabilities.setCapability("appActivity","com.quikr.old.SplashActivity");
        //desiredCapabilities.setCapability("avd","Nexus_6_API_23");
       desiredCapabilities.setCapability("avdReadyTimeout",120000);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities) {
        };

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }

    @After
    public void stopAppium() throws Exception {
        executorService.shutdown(); // Thread will stop here
        adbLogGeneration.generateADBLog(); // File will be created in logs directory
        appiumService.stop();
        driver.quit();
    }
    private void generateADBLog() throws Exception { // To start adb logcat via code
        executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            try {
                adbLogGeneration.deviceLog();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
