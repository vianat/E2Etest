package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import resources.base;

public class Hooks extends base {

	@Before
	public void start() throws IOException {

		Properties prop = new Properties();
		System.setProperty("webdriver.chrome.whitelistedIps", "");
		String dir = System.getProperty("user.home");
		prop.load(new FileInputStream(
				dir + "/IdeaProjects/E2Etest/src/test/java/resources/data.properties"));
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--log-level=3");
//			options.addArguments("--silent");
			options.addArguments("--headless");

//			run without UI
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		
		System.out.println(scenario.getStatus());

		if (scenario.isFailed()) {
			Date date = new Date();
			String screenshotFilename = date.toString().replace(" ", "-").replace(":", "-");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("target/ScreenShots/" + screenshotFilename + ".png"));
		}

		driver.quit();
	}
}