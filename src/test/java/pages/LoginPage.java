package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.ConfigProp;


public class LoginPage extends WebPage{
	
public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}
final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);


/* ## Web Elements ##*/
private  By saveButton  = By.xpath("//div[contains(text(),'Save')]/../..");
private  By emailTextbox = By.id("email-field");  
private  By passwordTextBox    = By.id("password-field");  
private  By signinButton    = By.id("submit-btn");
private  By userTitleLabel    = By.id("user-page-title");

private  By IncorrectUserPasswordLabel  = By.xpath("//div[contains(text(),'Incorrect email or password')]");
private  By emailFormatMessageLabel    = By.id("email-field-form-control-message");
private  By passwordMessageLabel    = By.id("password-field-form-control-message");

/* ## Web Elements error messages ##*/

/* ## Web Elements ##*/



/* ## Methods ##*/
	public LoginPage goToBookShelfUrl(){
		driver.get(ConfigProp.getUrl());
		return new LoginPage(driver);
	}
	

	/* ## Methods ##*/
		
		public LoginPage selectsaveCokies(){
			seleniumUtils.click(saveButton);
			return new LoginPage(driver);
		}
		
		public LoginPage LoginToBookShelfSuccess(String email,String password){
			seleniumUtils.setText(emailTextbox,email);
			seleniumUtils.setText(passwordTextBox,password);
			seleniumUtils.click(signinButton);
			seleniumUtils.waitLoginPageFinishLoad();
			return new LoginPage(driver);
		}
		
		/* ##  Assertion  ##  */
		
		public LoginPage validateUserIsinTheLoginPage(){
			seleniumUtils.AssertElementPresent(userTitleLabel);
			LOGGER.info("the Login page is displayed : " + driver.findElement(userTitleLabel).getText());
			return new LoginPage(driver);
		}
		
		public LoginPage validateIncorrectUserPasswordLabel(){
			seleniumUtils.AssertElementPresent(IncorrectUserPasswordLabel);
			LOGGER.info("the Login page is displayed : " + driver.findElement(IncorrectUserPasswordLabel).getText());
			return new LoginPage(driver);
		}
		
		public LoginPage validateemailFormatMessageLabel(){
			seleniumUtils.AssertElementPresent(emailFormatMessageLabel);
			LOGGER.info("the Login page is displayed : " + driver.findElement(emailFormatMessageLabel).getText());
			return new LoginPage(driver);
		}
		public LoginPage validatepasswordMessageLabel(){
			seleniumUtils.AssertElementPresent(passwordMessageLabel);
			LOGGER.info("the Login page is displayed : " + driver.findElement(passwordMessageLabel).getText());
			return new LoginPage(driver);
		}
		


}
