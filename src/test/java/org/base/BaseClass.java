package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 static WebDriver driver;
	
	public static WebDriver chromeBrowser() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
		
	public static void urlLaunch(String url) {
		driver.get(url); 
		driver.manage().window().maximize();
	}
		
	public static void wait(int Sec) {
		driver.manage().timeouts().implicitlyWait(Sec, TimeUnit.SECONDS);
		
	}
	
	public static void sendkeys(WebElement e,String value) {
		e.sendKeys(value);
	}
}
