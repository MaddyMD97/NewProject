package org.project.search;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSearch extends BaseClass {
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement SearchBox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	private By searchResults;
	
	
	public WebElement getSearchBox() {
		return SearchBox; 
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public By getSearchResults() {
		return searchResults;
	}
	
	}


