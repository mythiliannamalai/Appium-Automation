package apiDemo_Testing;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
public AppiumDriverLocalService service;
public AndroidDriver driver;

    @BeforeMethod
	public void configureAppium() throws MalformedURLException {
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();		
		service.start(); //start the appium server
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel XL API 33");
		options.setApp("C:\\Users\\Admin\\eclipse-workspace\\Appium_Mobile_\\src\\test\\java\\Resource\\ApiDemos-debug.apk");
				
	 driver= new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();  //close the app
		
		service.stop();  //stop the appium server
	}
}
