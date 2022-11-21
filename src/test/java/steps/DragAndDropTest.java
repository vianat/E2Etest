package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.DragAndDrop;
import resources.base;

import static org.testng.Assert.assertEquals;

public class DragAndDropTest extends base {
	
	DragAndDrop page = new DragAndDrop(driver);

	@When("drag element and drop on box")
	public void drag_element_and_drop_on_box() {
		Actions act = new Actions(driver);
		act.dragAndDrop(page.el, page.box).build().perform();
	}
	@Then("Check the box text changed to is {string}")
	public void checkTheBoxTextChangedToIs(String expected) {

		String actual = page.box.getText();
		System.out.println(actual);
		assertEquals(actual, expected);
	}

}