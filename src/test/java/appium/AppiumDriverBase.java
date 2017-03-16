package appium;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppiumDriverBase {

	protected AndroidDriver driver;
	protected WebDriverWait wait;

	//run once before all @test cases
	@BeforeTest
	protected void createAppiumDriver() throws MalformedURLException, InterruptedException {

		// relative path to apk file
		final File classpathRoot = new File(System.getProperty("user.dir"));
		final File appDir = new File(classpathRoot, "src/test/resources/apps/");
		final File app = new File(appDir, "ApiDemos-debug.apk");    			// Its a android app
		// final File app = new File(appDir, "selendroid-test-app-0.17.0.apk"); // Its a hybrid app
		

		// setting up desired capability
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", ""); // 'chrome' for browser else left blank for app
		caps.setCapability("platform", "ANDROID");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("deviceName", "ANDROID");
		caps.setCapability("app", app.getAbsolutePath());

		// initializing driver object
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		// initializing explicit wait object
		wait = new WebDriverWait(driver, 10);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
}

