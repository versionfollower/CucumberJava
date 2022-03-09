package steps;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.ConfigProp;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;


public class LoginSteps {
	final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
	WebDriver driver;
	DriverFactory driverFactory;
	LoginPage login;
	HomePage home;

	
	public void setup(){
	driverFactory= new DriverFactory();
	driverFactory.getDriver(ConfigProp.getBrowser());
	driver= driverFactory.driver();	
	login = new LoginPage(driver);
	home = new HomePage(driver);
	LOGGER.info("@BeforeTest- Setup");
	}
	
	public void tearDown(){
		driverFactory.tearDown();
		LOGGER.info("@AfterTest- tearDown");
	}
	
	@Before
	public void beforeScenario() {
		setup();
	}
	
	@After
	public void afterScenario() {
		tearDown();
	} 
	
	@Given("^I open the url BookShelf$") 
	   public void openBrowser() {
		login.goToBookShelfUrl().selectsaveCokies();
	   } 
	
	@When("^I Login to Book Shelf with email (.*) and password (.*)$") 
	   public void loginToBookShelf(String email, String password) throws InterruptedException {
		login.LoginToBookShelfSuccess(email, password);
		Thread.sleep(3000);//I added this because of running the tests, I added the logic for waiting to page load and wait until elements is visible
	   } 
	
	@When("^I click in log out$") 
	   public void selectLogout() {
		home.LogoutAccount();
	   } 
	
	@When("^I enter an (.*) with incorrect format$") 
	   public void loginToBookShelf(String email) throws InterruptedException {
		login.LoginToBookShelfSuccess(email, "");
	   } 
	@When("^I enter an email (.*) with empty password$") 
	   public void loginToBookShelfWithEmptyPassword(String email) throws InterruptedException {
		login.LoginToBookShelfSuccess(email, "");
	   } 
	
	
	@Then("^Account setting in Home page should be displayed with the email (.*)$") 
	   public void accountSettingShouldBeDisplayed(String email) {
		home.validateUserIsLoguedCorreclty(email);
	   } 
	
	@Then("^the user is in the Login Page$") 
	   public void LoginTitleIsDisplayed() {
		login.validateUserIsinTheLoginPage();
	   } 
	
	@Then("^I got an email valid format validation messages$") 
	   public void messageValidationEmailFormat() {
		login.validateemailFormatMessageLabel();
	   } 
	
	@Then("^I got a password empty validation messages$") 
	   public void messageValidationPasswordFormat() {
		login.validatepasswordMessageLabel();
	   } 
	
	@Then("^I got a email and password message validation messages$") 
	   public void passwordAndMessageValidationPasswordFormat() {
		login.validateIncorrectUserPasswordLabel();
	   } 
}