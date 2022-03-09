package drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFF extends Driver {


	@Override
	public void instanceDriver() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
