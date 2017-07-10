package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

//grindr app
public class RunApp {

	private static final String MobileElement = null;

	public static void main(String[] args) {

		IOSDriver driver = null;
		// WebDriverWait wait = new WebDriverWait(driver, 90);
		try {
			File app = new File("/Users/saranshjain/demo-test/src/main/resources/grindr_ios_regression1.zip");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("appium-version", "1.6.4");
			cap.setCapability("platformName", "iOS");
			cap.setCapability("platformVersion", "10.3");
			cap.setCapability("deviceName", "iPhone 7");
			cap.setCapability("automationName", "XCUITest");
			cap.setCapability("newCommandTimeout", "999999");
			cap.setCapability("app", app.getAbsolutePath());

			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.findElement(By.id("Email")).sendKeys("reg1@grindr.com");
			driver.findElement(By.id("Password")).sendKeys("111111");
			driver.findElement(By.id("Login")).click();
			// ((io.appium.java_client.MobileElement)
			// driver.findElement(MobileBy.className("XCUIElementTypePickerWheel"))).setValue("Top");
			// ((Object) driver).iOSXCUITFindby();
			//((io.appium.java_client.MobileElement) driver.findElementByIosNsPredicate("type CONTAINS 'PickerWheel'")).setValue("Top");
			// ((io.appium.java_client.MobileElement)
			// driver.findElementByIosNsPredicate("type CONTAINS
			// 'PickerWheel'")).findElementByClassName("XCUIElementTypeOther").click();
			// wait.until(ExpectedConditions.)

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("XCUIApplication().pickerWheels[\"Position - picker\"].adjustToPickerWheelValue(\"Top\")");

			Thread.sleep(30000);
			System.out.println("Done");
			// driver.quit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
