package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pageObjects.HoverOverPage;
import resources.base;
import static org.junit.jupiter.api.Assertions.assertEquals;
@Test
public class HoverOverTest extends base {
	HoverOverPage hop = new HoverOverPage(driver);
	@When("Move to {string} button")
	public void moveToButton(String str) {
		hoverOverOnElement(driver, hop.mainItem);
		hoverOverOnElement(driver, hop.SubList);
		hoverOverOnElement(driver, hop.SubList2);
	}
	@Then("Verify {string} button text")
	public void verifyButtonText(String string) throws InterruptedException {
		String actual = hop.SubList2.getText();
		Thread.sleep(1);
		String expected=string;
		assertEquals(actual,expected);
	}
	}
