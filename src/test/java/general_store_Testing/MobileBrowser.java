package general_store_Testing;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBrowser {
	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	    @BeforeMethod
		public void configureAppium() throws MalformedURLException {
			 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();		
			service.start(); //start the appium server
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("Pixel XL API 33");			
			options.setChromedriverExecutable("C:\\Users\\Admin\\Downloads\\chromedriver_win32_101V\\chromedriver.exe");		
		    options.setCapability("browserName", "Chrome");
			driver= new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	    @Test
	    public void search() {
	    	driver.get("https://www.google.com/");
	    	driver.findElement(By.name("q")).sendKeys("selenium");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    }
}
