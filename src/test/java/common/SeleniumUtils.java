package common;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class SeleniumUtils {
    WebDriver driver;
    WebDriverWait wait;
	private Object Assert;
	public SeleniumUtils(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	
	/* ### Selenium Actions ### */
	
	public void click(By element){
		waitWebElementClickableBy(element);
		driver.findElement(element).click();
	}
	
	public void waitLoginPageFinishLoad(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").equals("complete");
	}
	
	
	public void click(String Xpath){
		waitWebElementClickableBy(By.xpath(Xpath));
		driver.findElement(By.xpath(Xpath)).click();
	}

	public void setText(By element, String text){
		waitWebElementVisibleBy(element);
		driver.findElement(element).sendKeys(text);
	}

	public void mouseOver(String Xpath){
		waitWebElementVisibleBy(By.xpath(Xpath));
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(Xpath))).perform();		
	}
	
	public void mouseOver(By element){
		waitWebElementVisibleBy(element);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(element)).perform();		
	}
	
	
	public List<WebElement> getElements(By elements){
		waitWebElementsVisibleBy(elements);
		return driver.findElements(elements) ;
	}
	/* ### Explicit Wait ### */
	public void waitWebElementClickableBy(By element){
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitWebElementVisibleBy(By element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void waitWebElementsVisibleBy(By elements){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elements));
	}
	
	/* ### Asserts ### */ 
	public void AssertElementPresent(WebElement element){
		((junit.framework.Assert) Assert).assertTrue(element.isDisplayed());
	}
	
	public void AssertTextIsPresent(WebElement element,String text){
		System.out.print(element.getText()+"  ---  ");
		System.out.print(text);
		((junit.framework.Assert) Assert).assertTrue(element.getText().contains(text));
	}
	
	public void AssertElementPresent(By element){
		waitWebElementVisibleBy(element);
		((junit.framework.Assert) Assert).assertTrue(driver.findElement(element).isDisplayed());
	}
	
}
