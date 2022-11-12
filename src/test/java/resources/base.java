package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public static WebDriver driver = null;
	public static Properties prop;

	public static WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		String dir = System.getProperty("user.home");
		FileInputStream fis = new FileInputStream(
				dir + "/eclipse-workspace/E2Etest/src/test/java/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--log-level=3");
//			options.addArguments("--silent");
			options.addArguments("--headless");
			WebDriverManager.chromedriver().setup();

//			run without UI
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

//		} else if (browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//			System.getProperty("user.dir")+"\\drivers\\geckodriver-v0.31.0-win64.exe");
//			driver = new FirefoxDriver();
//			
//		} else if (browserName.equals("edge")) {
//			System.setProperty("webdriver.edge.driver",
//			System.getProperty("user.dir")+"\\E2EProject\\drivers\\msedgedriver104.exe");
//			driver = new EdgeDriver();
//		}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		return driver;
	}

	public static WebDriver navigateTo(WebDriver driver, String url) {
		driver.get(url);
		return driver;
	}
	public static void waitUntilElementToAppear(WebDriver driver, WebElement el){
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) el));
	}
	public static void waitUntilElementToDisAppear(WebDriver driver, WebElement el){
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	public static void tearDown() {
		driver.quit();
	}
}