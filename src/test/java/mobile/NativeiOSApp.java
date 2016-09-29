package mobile;

import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class NativeiOSApp {

    IOSDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        File app = new File("/Users/sheetal/Documents/appiumapps/TestApp.app");
        //File app = new File("/Users/sheetal/Documents/appiumapps/UICatalog.app");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, app);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5");

        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        driver.closeApp();
    }

    //For TestApp.app
    @Test
    public void test1() throws InterruptedException {
        driver.findElementById("TextField1").sendKeys("49");
        Thread.sleep(3000);
        driver.findElementById("IntegerB").sendKeys("71");
        Thread.sleep(3000);
        driver.findElementById("ComputeSumButton").click();
        Thread.sleep(3000);
        System.out.println("Sum is: "+driver.findElementByName("Answer").getText());
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();

    }

    //For UICatalog.app
    //@Test
    public void test2(){
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
        driver.findElement(By.name("Back")).click();
    }


}
