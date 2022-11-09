package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\viana\\eclipse-workspace\\E2ETest\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
		
//			run without UI
			if (browserName.contains("headless")){options.addArguments("headless");}
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
			System.getProperty("user.dir")+"\\drivers\\geckodriver-v0.31.0-win64.exe");
			driver = new FirefoxDriver();
			
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
			System.getProperty("user.dir")+"\\E2EProject\\drivers\\msedgedriver104.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public void getScreenshot(String testMethodName, WebDriver driver2){

		String screenName = System.currentTimeMillis() + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try{
			FileHandler.copy(src, new File(System.getProperty("user.dir") 
					+ "\\target\\Screenshots\\" + screenName + ""));
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

}
