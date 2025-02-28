package utils;

import java.util.List;

import org.openqa.selenium.*;

import com.practicetestautomation.base.BaseTest;

public class ElementFetch {

	public WebElement getWebElement(String identifierType, String identifierValue)
	{
		switch(identifierType) {
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifierValue));
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
		case "NAME":
			return BaseTest.driver.findElement(By.name(identifierValue));


		default:
			return null;
		}
	}

	public List<WebElement> getWebElements(String identifierType, String identifierValue)
	{
		switch(identifierType) {

		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifierValue));
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifierValue));
		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));
		case "NAME":
			return BaseTest.driver.findElements(By.name(identifierValue));

		default:
			return null;
		}
	}
	public void elementExists(String identifierType, String identifierValue)
	{
		switch(identifierType) {
		case "XPATH":
			//	WebElement elementExists = BaseTest.driver.findElement(By.xpath(identifierValue));
			if (BaseTest.driver.findElement(By.xpath(identifierValue)) != null )
				//if (elementExists.getSize() != null )
				System.out.println("Element present");	
			else{
				//Else if size is 0, then element is not present
				System.out.println("Element not present");}
			break;
		case "CSS":
			if (BaseTest.driver.findElement(By.cssSelector(identifierValue)) != null )
				//if (elementExists.getSize() != null )
				System.out.println("Element present");	
			else{
				//Else if size is 0, then element is not present
				System.out.println("Element not present");}
			break;
		case "ID":
			//WebElement elementExists = BaseTest.driver.findElement(By.xpath(identifierValue));
			if (BaseTest.driver.findElement(By.id(identifierValue)) != null )
				System.out.println("Element present");	
			else{
				//Else if size is 0, then element is not present
				System.out.println("Element not present");}
			break;
		case "NAME":
			//WebElement elementExists = BaseTest.driver.findElement(By.xpath(identifierValue));
			if (BaseTest.driver.findElement(By.name(identifierValue)) != null )
				System.out.println("Element present");	
			else{
				//Else if size is 0, then element is not present
				System.out.println("Element not present");


			}
		}

	}
}

