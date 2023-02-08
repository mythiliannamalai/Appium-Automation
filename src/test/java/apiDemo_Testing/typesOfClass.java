package apiDemo_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class typesOfClass extends BaseClass{
	@Test
	public void screenRoutate() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation land=new DeviceRotation(0,0,90);
		driver.rotate(land);
	}
	@Test
	public void clipBoard() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.setClipboardText("Mythili Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
	@Test
	public void keyEvent() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();	
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();			
		driver.findElement(By.id("android:id/edit")).sendKeys("Mythili Wifi");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));		
	}
	@Test
	public void activityClass() {
		Activity act = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
	    driver.startActivity(act);
	    driver.findElement(By.id("android:id/checkbox")).click();	
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();			
		driver.findElement(By.id("android:id/edit")).sendKeys("Mythili Wifi");
	}
}
