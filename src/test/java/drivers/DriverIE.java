package drivers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverIE extends Driver {

	protected DriverIE() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void instanceDriver() {
		File file = new File("C://iexploredriver.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
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
