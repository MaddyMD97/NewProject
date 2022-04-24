package org.project.search;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RealME extends BaseClass {

	public static void main(String[] args) {
		
		WebDriver driver = chromeBrowser();
		System.out.println("----------Brower Lanched----------");
		
		urlLaunch("https://www.amazon.in/");
		System.out.println("----------URL Lanched----------");
		
		wait(20);
		System.out.println("----------Wait Applied----------");
		
		ProjectSearch ps=new ProjectSearch();
		
//		sendkeys(ps.getSearchBox(), "realme xt");
//		clickit(ps.getSearchButton());
//		List<WebElement> results= driver.findElements(ps.getSearchResults());
		System.out.println();
		System.out.println("--------->input 'realme xt' in search box");
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbox.sendKeys("realme xt");	
		
		System.out.println("--------->click on search");
		WebElement searchbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		searchbtn.click();
		
 		List<WebElement> results= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		List<String> PN = new LinkedList<String>();
		
		for (WebElement x: results) {
		//System.out.println(x.getText());
		PN.add(x.getText());
		}
		
		System.out.println();
		System.out.println("----------Your Search Results for 'realme xt'----------");
		
		for (String Z:PN) {
			System.out.println(Z);
		}
		
		List<WebElement> prices= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		System.out.println();
		System.out.println("----------Price list of your products'----------");
		
		List<Integer> FP = new LinkedList<Integer>();
		List<Integer> SortedFP = new LinkedList<Integer>();
		
		for (WebElement listedPrices:prices) {
			
			if(listedPrices.getText().contains(",")) 
			{
				String finalPrice = listedPrices.getText();
				finalPrice=finalPrice.replace(",","");
				System.out.println(finalPrice);	
				int FF = Integer.parseInt(finalPrice);
				FP.add(FF);
				SortedFP.add(FF);
			}
			
		}
		
		System.out.println("----------------------------");
//Sorted;
		
		Collections.sort(SortedFP); 
		
		System.out.println();
		System.out.println("Minimun Price is.... "+ SortedFP.get(0));		
		System.out.println("Maximum Price is.... "+ SortedFP.get(SortedFP.size()-1)); 
        
		System.out.println();
		System.out.println("--------------Wiithout Mapping--------------");
		
//without Mapping
		System.out.println("Name & Price");
		for (int i=0; i<FP.size();i++) {
			System.out.println(PN.get(i)+"===="+FP.get(i));
		}
		
		System.out.println();
		System.out.println("--------------By Mapping--------------");
		
		Map<String, Integer> mp=new LinkedHashMap<String, Integer>();
		
		for(int i=0;i<FP.size();i++) {
			mp.put(PN.get(i), FP.get(i));
		}
		
//System.out.println(mp);
		
		System.out.println();
		System.out.println("--------------Iterated by entry set--------------");
		Set<Entry<String, Integer>> et= mp.entrySet();
		
		for (Entry<String, Integer> y : et) {
			System.out.println(y);
		}
		
		System.out.println();
		
		driver.quit();
		
	}
}
