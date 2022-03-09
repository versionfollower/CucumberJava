package drivers;


import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


 abstract class Driver {
	 final Logger LOGGER = LoggerFactory.getLogger(Driver.class);	
	
	protected WebDriver driver;
	
	public abstract void instanceDriver();

	public abstract void freeDriver();

	public abstract WebDriver returnDriver();

}
