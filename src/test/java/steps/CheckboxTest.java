package steps;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Check_boxPage;
import resources.base;

public class CheckboxTest extends base {

	Check_boxPage ch = new Check_boxPage(driver);
	
	@And("^user clicks on toggle")
	public void user_clicks_on_toggle() {
		ch.toggle().click();
	}

	@When("clicks on checkbox")
	public void clicks_on_checkbox() {
		ch.home().click();
	}

	@Then("you should be able to see what checkbox you have selected")
	public void you_should_be_able_to_see_what_checkbox_you_have_selected() {
		String actual = ch.home().getAttribute("class");
		String expected = "rct-icon rct-icon-check";
		assertEquals(actual, expected);
	}
}