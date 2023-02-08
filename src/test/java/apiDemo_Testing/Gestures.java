package apiDemo_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Gestures extends BaseClass {
	@Test
	public void longPress() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"duration",2000));
	WebElement ele = driver.findElement(By.id("android:id/title"));
	String text=ele.getText();
		Assert.assertEquals(text,"Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	}
	
	@Test
	public void scroll() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
	}
	@Test
	public void swipe() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement element = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"direction","left",
						"percent",0.75));
		
	}
	
	@Test
	public void dragAnddrop() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement element = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"endX",647,
						"endY",586));
		WebElement ele = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text"));
		String msg = ele.getText();
		Assert.assertEquals(msg,"Dropped!");
	}
	
}
