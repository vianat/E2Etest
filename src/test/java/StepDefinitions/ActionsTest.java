package StepDefinitions;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.ButtonsPage;
import resources.base;

@Test
public class ActionsTest extends base {
	
	ButtonsPage bp = new ButtonsPage(driver);
	
	@Given("I navigate to {string}")
	public void I_navigate_to(String string) throws InterruptedException {
		base.navigateTo(driver, string);
	}
	
	@And("Do {string} click on the {string} button")
	public void do_click_on_the_button(String string, String string2) throws InterruptedException {

		if(string.equals("dynamic")) {
			dynamicClickOnElement(driver, bp.clickMeBtn);
		}
		else if(string.equals("right")) {
			rightClickOnElement(driver, bp.rightClickBtn);
		}
		else if(string.equals("double")) {
			doubleClickOnElement(driver, bp.doubleClickBtn);
		}
	}
	
	@Then("Verify that {string} messege {string} is present")
	public void verify_that_messege_is_present(String string, String string2) {
		
		if(string.equals("dynamic")) {
			string = getTextFromElement(driver, bp.dynamicClickMessage);	
		}
		else if(string.equals("right")) {
			string = getTextFromElement(driver, bp.rightClickMessage);	
		}
		else if(string.equals("double")) {
			string = getTextFromElement(driver, bp.doubleClickMessage);	
		}
		assertEquals(string, string2);
	}
}