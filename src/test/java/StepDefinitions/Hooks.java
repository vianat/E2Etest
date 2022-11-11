package StepDefinitions;

import java.io.IOException;

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
		System.out.println("*************************** HOOK BEFORE *****************");
		driver = base.initializeDriver();
	}

	@After
	public void quit(Scenario scenario) {
		System.out.println("**************************** HOOK AFTER ******************");

		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "target/ScreenShots/", scenario.getName());
		}

		base.tearDown();
	}

}
