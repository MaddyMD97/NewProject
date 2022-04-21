package org.project.search;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RealME extends BaseClass {

	public static void main(String[] args) {
		WebDriver driver = chromeBrowser();
				
		urlLaunch("https://www.amazon.in/");
		
		wait(20);
		
//		ProjectSearch ps=new ProjectSearch();
//		sendkeys(ps.getSearchBox(), "realme xt");
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbox.sendKeys("realme xt");
		
		WebElement searchbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		searchbtn.click();
		
		List<WebElement> results= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		System.out.println("----------Your Search Results for 'realme xt'----------");
		
		for (WebElement x: results) {
		System.out.println(x.getText());
		}
		
		List<WebElement> prices= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		System.out.println("----------Price list of your products'----------");
		
		List<Integer> FP = new LinkedList<Integer>();
		
		for (WebElement listedPrices:prices) {
			
			if(listedPrices.getText().contains(",")) 
			{
				String finalPrice = listedPrices.getText();
				finalPrice=finalPrice.replace(",","");
				System.out.println(finalPrice);	
				int FF = Integer.parseInt(finalPrice);
				FP.add(FF);
			}
			
		}
		
		System.out.println("----------------------------");
		//System.out.println(FP);
		
		Collections.sort(FP);
		
		//System.out.println(FP);

		System.out.println("Minimun Price is.... "+ FP.get(0));		
		System.out.println("Maximum Price is.... "+ FP.get(FP.size()-1)); 
         
	}
	
}
