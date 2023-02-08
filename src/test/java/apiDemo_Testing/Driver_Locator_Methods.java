package apiDemo_Testing;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;


public class Driver_Locator_Methods extends BaseClass {
	@Test
	public void wifiSettingName() throws MalformedURLException  {	
		
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
	driver.findElement(By.id("android:id/checkbox")).click();	
	driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String text=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(text,"WiFi settings");
	driver.findElement(By.id("android:id/edit")).sendKeys("Mythili Wifi");
	driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
}
