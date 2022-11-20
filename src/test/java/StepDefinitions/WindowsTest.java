package StepDefinitions;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.WindowsPage;
import resources.base;

public class WindowsTest extends base {
	
	Scenario scenario;
	WindowsPage wp = new WindowsPage(driver);
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@And("Click on the {string} button")
	public void click_on_the_button(String string) {

		if (string.equals("New Tab")) 				wp.tabBtn.click();
		if (string.equals("New Window")) 			wp.windowBtn.click();
		if (string.equals("New Window Message"))	wp.messageBtn.click();
	}

	@And("Switch to new tab or window")
	public void Switch_to_new_tab_or_window() {
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
	}

	@And("Verify that {string} is present in new tab or window")
	public void verify_that_is_present_in_new_tab_or_window(String string) {
		String scenarioName = scenario.getName();
		String actual;
		if (scenarioName.equals("Switch to new tab") || scenarioName.equals("Switch to new window")) {
			actual = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
		} else {
			actual = driver.findElement(By.xpath("/html[1]/body[1]")).getText();
		}
		assertEquals(actual, string);
	}

	@Then("Close the tab or window")
	public void close_the_tab() {
		driver.close();
	}

	@And("Switch back")
	public void switch_back() {
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(0));
	}
}