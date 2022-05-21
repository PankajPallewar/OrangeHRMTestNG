package WebControllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserController {

	WebDriver driver;

	public WebDriver openWebsite(String site){
		System.setProperty("webdriver.chrome.driver", "D://Softwares/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(site);
		driver.manage().window().fullscreen();
		return driver;
	}

	public static void closeBrowser(WebDriver driver){ driver.close(); }

}
