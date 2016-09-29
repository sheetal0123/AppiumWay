package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SampleTestCase extends AppiumDriverBase {

	// Test Annotation changes any java function to TestNG test case
	// @Test
	public void sampeTest() {

		// click on Accessibility link
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility")));
		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();

		// click on 'Accessibility Node Querying' link
		wait.until(
				ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility Node Querying")));
		driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();

		// back
		driver.navigate().back();

		// back
		driver.navigate().back();
	}

	// @Test
	public void clickAndTap() {

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Views")));
		// driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.tap(1, driver.findElementByAccessibilityId("Views"), 500);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Buttons")));
		// driver.findElement(MobileBy.AccessibilityId("Buttons")).click();
		driver.tap(1, driver.findElementByAccessibilityId("Buttons"), 500);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Toggle")));
		// driver.findElement(MobileBy.AccessibilityId("Toggle")).click();
		driver.tap(1, driver.findElementByAccessibilityId("Toggle"), 500);

		String a = driver.findElement(MobileBy.AccessibilityId("Toggle")).getText();
		System.out.println("Toggle Text: " + a);

	}

	// @Test
	public void dragAndDrop() {

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Views")));
		driver.tap(1, driver.findElementByAccessibilityId("Views"), 500);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Drag and Drop")));
		driver.tap(1, driver.findElementByAccessibilityId("Drag and Drop"), 500);

		WebElement dot1 = driver.findElement(By.id("drag_dot_1"));
		WebElement dot3 = driver.findElement(By.id("drag_dot_3"));

		TouchAction ta = new TouchAction(driver);
		ta.longPress(dot1).moveTo(dot3).release().perform();

	}

	// @Test
	public void swipeVertically() {

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Views")));
		driver.tap(1, driver.findElementByAccessibilityId("Views"), 500);

		// AndroidElement listView = (AndroidElement)
		// driver.findElementByClassName("android.widget.ListView");
		AndroidElement listView = (AndroidElement) driver.findElementById("list");

		listView.swipe(SwipeElementDirection.UP, 20, 15, 1000);
		listView.swipe(SwipeElementDirection.DOWN, 20, 15, 1000);
	}

	// @Test
	public void swipeHorizontally() {

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Views")));
		driver.tap(1, driver.findElementByAccessibilityId("Views"), 500);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Gallery")));
		driver.tap(1, driver.findElementByAccessibilityId("Gallery"), 500);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("1. Photos")));
		driver.tap(1, driver.findElementByAccessibilityId("1. Photos"), 500);

		// AndroidElement listView = (AndroidElement)
		// driver.findElementById("io.appium.android.apis:id/gallery");
		// AndroidElement listView = (AndroidElement)
		// driver.findElementByClassName("android.widget.Gallery");

		// listView.swipe(SwipeElementDirection.RIGHT, 5, 5, 2000);
		// listView.swipe(SwipeElementDirection.LEFT, 20, 15, 1000);

		AndroidElement hgallery = (AndroidElement) driver.findElementById("io.appium.android.apis:id/gallery");
		hgallery.swipe(SwipeElementDirection.LEFT, 5, 5, 1000);
		hgallery.swipe(SwipeElementDirection.RIGHT, 5, 5, 1000);

	}

	// @Test
	public void orientation() throws InterruptedException {

		System.out.println("Current Orientation: " + driver.getOrientation());
		driver.rotate(ScreenOrientation.LANDSCAPE);

		Thread.sleep(5000);

		System.out.println("Current Orientation: " + driver.getOrientation());
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

	// @Test
	public void appLaunchClose() {
		System.out.println("Current Activity: " + driver.currentActivity());
		driver.closeApp();
		driver.launchApp();
		System.out.println("Current Activity: " + driver.currentActivity());
		driver.removeApp("io.appium.android.apis");
		System.out.println(driver.isAppInstalled("io.appium.android.apis"));

	}

	@Test
	public void lockUnlock() {
		System.out.println("UnLocked: " + driver.isLocked()); // false
		driver.lockDevice();
		System.out.println("Locked: " + driver.isLocked()); // true
		driver.unlockDevice();
		System.out.println("UnLocked: " + driver.isLocked()); //false
	}
	
	
	//@Test
	public void networkSettings(){
		driver.setConnection(Connection.ALL);
		System.out.println(driver.getConnection());
		
		driver.setConnection(Connection.AIRPLANE);
		System.out.println(driver.getConnection());

		driver.setConnection(Connection.NONE);
		System.out.println(driver.getConnection());
		
		driver.setConnection(Connection.WIFI);
		System.out.println(driver.getConnection());

		driver.setConnection(Connection.DATA);
		System.out.println(driver.getConnection());
	}

	
	//@Test
	public void longPress(){
		driver.startActivity("io.appium.android.apis", ".view.Buttons1");
		  TouchAction action=new TouchAction(driver);
		  action.longPress(driver.findElementById("io.appium.android.apis:id/button_toggle")).release().perform();
		
	}
	
	
	//@Test
	public void zoomInOut() throws InterruptedException{
		
		driver.startActivity("io.appium.android.apis", ".ApiDemos");
		MobileElement e = (MobileElement) driver.findElement(MobileBy.AccessibilityId("App"));
		Thread.sleep(500);
		e.zoom();
		Thread.sleep(500);
		e.pinch();
	}
	
	//@Test
	public void notifications(){
		driver.openNotifications();
		System.out.println("Notification Size: "+driver.findElements(By.id("com.android.systemui:id/carrier_label")).size());
	}
	
	
	//@Test
	public void keyCode(){
		driver.launchApp();
		driver.longPressKeyCode(AndroidKeyCode.HOME);
		
	}
	
	
	//@Test
	public void hybridApp(){
		//selendroid app
		
	}

}
