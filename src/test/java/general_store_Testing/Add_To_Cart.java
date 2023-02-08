package general_store_Testing;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;


import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;


public class Add_To_Cart extends Ecommerce_Application{
	 @Test
	    public void add_to_Cart() throws InterruptedException {
	    	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	    	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
	    	driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mythili");
	    	driver.hideKeyboard();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    	
	    	// After login
	    	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
	    	int size = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	    	
	    	for(int i=0;i<size;i++) 
	    	{
	    		String title = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	    		if(title.equalsIgnoreCase("Jordan 6 Rings")) {
	    			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
	    		}
	    	}
	    	Thread.sleep(3000);
	    	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	    	
	    	//waits
	    	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/productName")),"text","Jordan 6 Rings"));
	    	
	    	// Assersion	    	
	    	String title = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
	    	Assert.assertEquals(title,"Jordan 6 Rings");
	    	
	    }
	 
	    @Test
	    public void addTocart_SumThePrice_visitTheWebSite() throws InterruptedException {
	    	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	    	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
	    	driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mythili");
	    	driver.hideKeyboard();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    	
	    	// After login
	    	driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
	    	//Thread.sleep(3000);
	    	driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
	    	Thread.sleep(3000);
	    	//click the cart button
	    	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	    	// add the price values
	    	List <WebElement> element = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	    	int count =element.size();
	    	double totalPrice=0;
	    	
	    	for(int i=0;i<count;i++) {
	    		String amount = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
	    		double price= Double.parseDouble(amount.substring(1));
	    		totalPrice = totalPrice + price;	    			    		
	    	}
	    	String amount= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	    	double price= Double.parseDouble(amount.substring(1));
	    	Assert.assertEquals(price,totalPrice);
	    	
	    	  // long press
	    	WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
			((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
			driver.findElement(By.id("android:id/button1")).click();
			// click the checkbox
			driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
			
			//click the visit to website button
			driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
			// swite the control to web
			Thread.sleep(6000);
			Set <String> wele = driver.getContextHandles();
			for(String contextName : wele) {
				System.out.println(contextName);
	    }
			driver.context("WEBVIEW_com.androidsample.generalstore");
			driver.findElement(By.name("q")).sendKeys("selenium");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
				// swite the control to native
			driver.context("NATIVE_APP");
		
		}
}
