package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Check_boxPage;
import resources.base;

public class CheckboxSteps extends base {
	Check_boxPage ch;

	@Given("user clicks on toggle")

	public void user_clicks_on_toggle() {
		navigateTo(driver, "http://demoqa.com/checkbox");
		ch = new Check_boxPage(driver);
		ch.toggle().click();
	}

	@When("clicks on checkbox")
	public void clicks_on_checkbox() {
		ch.home().click();
	}

	@Then("you should be able to see what checkbox you have selected")
	public void you_should_be_able_to_see_what_checkbox_you_have_selected() {
		System.out.println("You are on checkbox page");
	}

}
