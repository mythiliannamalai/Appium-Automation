package general_store_Testing;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Ecommerce_Application {
	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	    @BeforeMethod
		public void configureAppium() throws MalformedURLException {
			 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();		
			service.start(); //start the appium server
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("Pixel XL API 33");
			options.setApp("C:\\Users\\Admin\\eclipse-workspace\\Appium_Mobile_\\src\\test\\java\\Resource\\General-Store.apk");
			options.setChromedriverExecutable("C:\\Users\\Admin\\Downloads\\chromedriver_win32_101V\\chromedriver.exe");		
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	    @Test
	    public void login() {
	    	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	    	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
	    	driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mythili");
	    	driver.hideKeyboard();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    }
	    @Test
	    public void login_verifyErrorMsg(){    
	    	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	        String toastmsg = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
	        Assert.assertEquals(toastmsg,"Please enter your name");
	    }
	   	    
	   
}
