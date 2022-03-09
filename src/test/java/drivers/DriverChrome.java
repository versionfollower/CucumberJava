package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.ConfigProp;



public class DriverChrome extends Driver {
	
	@Override
	public void instanceDriver(){
		
		System.setProperty("webdriver.chrome.driver",ConfigProp.getChromePath());
		LOGGER.debug("webdriver.chrome.driver,ConfigProp.getChromePath()");
		driver = new ChromeDriver();
		// return driver;
	}

	@Override
	public void freeDriver() {
		driver.quit();
	}

	@Override
	public WebDriver returnDriver() {
		return driver;
	}

}
