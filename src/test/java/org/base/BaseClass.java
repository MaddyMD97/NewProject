package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
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
	

}
