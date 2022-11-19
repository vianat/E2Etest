package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageObjects.FramePage;
import pageObjects.TestPage;
import resources.BaseClass;
import resources.base;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static resources.base.driver;

@Test
public class TestFrameTest extends BaseClass {

	TestPage fp = new TestPage(driver);

	@When("Switch to frame2")
	public void switchToFrame(String name) throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(fp.getFrame(name));
	}

	@And("step")
	public void step(String page, DataTable dataTable ) {
		List<String> AllElementsInTheList = dataTable.asList(String.class);

		for (int i = 0; i < AllElementsInTheList.size(); i++) {
			getPage(page).hoverOverTheElement(AllElementsInTheList.get(i));
		}
	}

	public void hoverOverTheElement(String element) {
		moveToElementAndClick(getWebElement(map, element));
	}
}