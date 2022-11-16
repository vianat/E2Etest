package StepDefinitions;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.AlertPage;
import resources.base;

@Test
public class AlertTest extends base {

	AlertPage ap = new AlertPage(driver);

	@And("Clicks on the {string} button")
	public void clicks_on_the_button(String string) {
		if (string.equals("First")) {
			ap.alertBtn.click();
		}
		if (string.equals("Second")) {
			ap.timerBtn.click();
		}
		if (string.equals("Third")) {
			ap.confirmBtn.click();
		}
		if (string.equals("Fourth")) {
			ap.promtBtn.click();
		}

	}

	@And("Get and verify message from alert {string}")
	public void get_and_verify_message_from_alert(String string) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		String actual = driver.switchTo().alert().getText();
		assertEquals(actual, string);
		System.out.println(actual + " ****" + string);
	}

	@And("Enters name {string}")
	public void enter_name(String string) {
		driver.switchTo().alert().sendKeys(string);

	}

	@Then("Accept the alert")
	public void accept_the_alert() {
		driver.switchTo().alert().accept();
	}

	@Then("Decline the alert")
	public void decline_the_alert() {
		driver.switchTo().alert().dismiss();
	}
}