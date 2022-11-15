package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import resources.base;

public class Hooks extends base {

	@Before
	public void start() throws IOException {

		Properties prop = new Properties();
		String dir = System.getProperty("user.home");
		FileInputStream fis = new FileInputStream(
				dir + "/eclipse-workspace/E2Etest/src/test/java/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--log-level=3");
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		
		System.out.println(scenario.getStatus());

		if (scenario.isFailed()) {
			Date currentdate = new Date();
			String screenshotFilename = currentdate.toString().replace(" ", "-").replace(":", "-");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("target/ScreenShots/" + screenshotFilename + ".png"));
		}

		driver.quit();
	}

}
