package mobile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebAndroidTest {

    AppiumDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");

        //optional
        capabilities.setCapability("avd", "Nexus_5");//shd match
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.google.co.in");


        Thread.sleep(5000);
//		driver.findElement(By.name("Email")).sendKeys("sheetal0123");
//		driver.findElement(By.name("Passwd")).sendKeys("test");
//		driver.findElement(By.name("signIn")).click();
    }






}
