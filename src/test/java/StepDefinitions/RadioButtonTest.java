package StepDefinitions;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.base;

public class RadioButtonTest extends base {

	WebElement radio;
	
	@And("user is on webpage")
	public void user_is_on_webpage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}

	@When("clicks on radio button")
	public void clicks_on_radio_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		radio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
		
		dynamicClickOnElement(driver, radio);
	}

	@Then("you should be able to see button is selected")
	public void you_should_be_able_to_see_button_is_selected() throws InterruptedException {
		assertEquals(radio.isSelected(), false);
	}
}