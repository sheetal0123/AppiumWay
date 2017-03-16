package mobile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class NativeAndroidTest {

	AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        
        caps.setCapability("browserName", ""); // 'chrome' for browser else left blank for app
		caps.setCapability("platform", "ANDROID");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("deviceName", "ANDROID");
       
        //For Calculator apk
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        //Dialer Pad - No apk setting req in appium server
        //caps.setCapability("appPackage", "com.android.dialer");
        //caps.setCapability("appActivity", "com.android.dialer.DialtactsActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    //@Test
    public void calculatorTest() throws InterruptedException {
        driver.findElementById("digit_5").click();
        driver.findElementById("op_add").click();
        driver.findElement(By.id("digit_6")).click();
        driver.findElementByAccessibilityId("equals").click();
        System.out.println("Sum is: "+driver.findElement(By.id("com.android.calculator2:id/formula")).getText());
    }


    @Test
    public void DialerPadTest(){
        driver.findElementById("floating_action_button").click();
        WebElement zero=driver.findElement(By.id("com.android.dialer:id/zero"));

        //Enter mobile no as   +919911872805
        //long press code
        TouchAction action=new TouchAction(driver);
        action.longPress(zero).perform(); //type +

        driver.findElementByAccessibilityId("9").click();
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("9").click();
        driver.findElementByAccessibilityId("9").click();
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("1").click();

        driver.findElementById("eight").click();
        driver.findElementById("seven").click();
        driver.findElementById("two").click();
        driver.findElement(By.id("eight")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.id("five")).click();

        //make a call
        driver.findElementById("com.android.dialer:id/dialpad_floating_action_button").click();

        //end a call
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//		driver.findElementById("floating_end_call_action_button").click();//emulator not responding properly

    }
}
