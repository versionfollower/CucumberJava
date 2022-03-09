package drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public Driver genericDriver;

	public void getDriver(String browser){
		switch (browser) {
		case "ff":
			genericDriver = new DriverFF();
			break;
		case "chrome":
			genericDriver = new DriverChrome();
			break;
		default:
			genericDriver = null;
			break;
		}
		genericDriver.instanceDriver();
	}

	public void tearDown() {
		genericDriver.freeDriver();
	}

	public WebDriver driver() {
		return genericDriver.returnDriver();
	}

}
