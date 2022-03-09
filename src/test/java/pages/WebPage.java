package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.SeleniumUtils;
import common.Utilities;

public class WebPage {
protected WebDriver driver;
public SeleniumUtils seleniumUtils;
Utilities util;
final Logger LOGGER = LoggerFactory.getLogger(WebPage.class);

public WebPage(WebDriver driver){
	seleniumUtils = new SeleniumUtils(driver);
	util = new Utilities();
	this.driver = driver;
	PageFactory.initElements(driver, this);
}



	
	//LOGGER.info(texto);
		
	
}
