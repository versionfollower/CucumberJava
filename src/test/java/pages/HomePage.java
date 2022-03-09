package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class HomePage extends WebPage{
	
public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}
final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);



/* ## Web Elements ##*/
private  By accountSettingsButton  = By.xpath("//button[@aria-label='Account Settings']");
private  By accountUserLabel  = By.xpath("//h3[.='Account']/../../../div/span[2]");
private  By logOutButton  = By.xpath("//div[.='Sign Out']/../../a/..");

private  By sortingSection = By.xpath(".//a[contains(@aria-controls,'SortMenu')]");  //Best Match
private  By listPrices     = By.xpath(".//li/div//span[contains(@class,'bold')]");  
private  By listNames      = By.xpath(".//li/div//a[contains(@class,'vip')]");


	/* ## Methods ##*/
	
	public LoginPage LogoutAccount(){
		
		seleniumUtils.click(logOutButton);
		return new LoginPage(driver);
	}
	
	/* ##  Assertion  ##  */
	                
	public HomePage validateUserIsLoguedCorreclty(String text){
		seleniumUtils.click(accountSettingsButton);
		seleniumUtils.AssertTextIsPresent(driver.findElement(accountUserLabel),text);
		LOGGER.info("the user is displayed the account : " + driver.findElement(accountUserLabel).getText());
		return new HomePage(driver);
	}
	
	

}
