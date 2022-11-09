package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxSteps {
	
	@Given("user is on checkbox page")
	
	public void user_is_on_checkbox_page() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/");
	System.out.println("You are on checkbox page");
	}

	@When("when user clicks on toggle")
	public void when_user_clicks_on_toggle() {
		System.out.println("User clicked toggle");
	}

	@When("clicks on checkbox")
	public void clicks_on_checkbox() {
		System.out.println("User clicked toggle");
	}

	@Then("you should be able to see what checkbox you have selected")
	public void you_should_be_able_to_see_what_checkbox_you_have_selected() {
		System.out.println("You are on checkbox page");
	}


}
