package steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.FramePage;
import resources.base;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest extends base {

	FramePage fp = new FramePage(driver);
	String actual;

	@When("Switch to frame")
	public void switchToFrame(String name) throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(fp.getFrame(name));
	}

	@And("Get text from frame")
	public void getTextFromFrame() {
		actual = driver.findElement(By.tagName("body")).getText();
	}

	@Then("Verify text {string} is present in frame")
	public void verifyTextIsPresentInFrame(String expected) {
		assertEquals(actual, expected);
	}
}