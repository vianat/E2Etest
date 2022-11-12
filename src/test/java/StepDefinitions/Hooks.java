package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import resources.base;

public class Hooks {

	// With hook class I am telling to program to start and to finish

	WebDriver driver;

	@Before
	public void start() throws IOException {

		driver = base.initializeDriver();
	}

	@After
	public void quit(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
//			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "target/ScreenShots/", scenario.getName());
			Date currentdate = new Date();
			String screenshotFilename = currentdate.toString().replace(" ", "-").replace(":", "-");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("target/ScreenShots/" + screenshotFilename + ".png"));
		}

		base.tearDown();
	}

}
