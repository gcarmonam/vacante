package falabellaUtiles;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import falabellaPage.searchPage;

public class Utiles {
	protected WebDriverWait wait;
	public static WebDriver driver;
	public static searchPage searchPage;
	
	@SuppressWarnings("deprecation")
	public static WebDriver getDriver() {
		
		try {
			//Configurar browser a operar
			String browserName = "chrome";
			System.out.println("Browser: " + browserName);
			switch (browserName) {

			case "chrome":
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", "src/test/java/Resources/chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;

			case "ie":
				if (null == driver) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", "src/test/java/Resources/IEDriverServer.exe");
					capabilities.setCapability("ignoreZoomSetting", true);
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					driver = new InternetExplorerDriver(capabilities);
					driver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("No se cargo browser:" + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			searchPage	= PageFactory.initElements(driver, searchPage.class);			
		}		
		return driver;	
	}
	
	public void JsPageScroll(int numb1, int numb2) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(" + numb1 + "," + numb2 + ")");
		} catch (Exception e) {
			Assert.fail("No es posible realizar scroll a WebElement: " + e.getMessage());
		}
	}
	
}
