package StepDefinitions;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.TablePage;
import resources.base;

@Test
public class TableTest extends base {
	
	TablePage tp = new TablePage(driver);
	
	@Given("Click [Add] button")
	public void click_add_button() throws InterruptedException {
		
		base.navigateTo(driver, "https://demoqa.com/webtables");
		tp.clickBtn(tp.addBtn);
		
//		waitUntilElementToAppear(driver, tp.dialog);
	}
	
	@Then("^Fill all inputs fields (.+),(.+),(.+),(.+),(.+),(.+)")
	public void fill_all_inputs_fields(String fn, String ln, String em, String age,  String sal, String dep) throws InterruptedException {
		
		tp.insertText(tp.firstName, fn);
		tp.insertText(tp.lastName, ln);
		tp.insertText(tp.userEmail, em);
		tp.insertText(tp.age, age);
		tp.insertText(tp.salary, sal);
		tp.insertText(tp.department, dep);
	}

	@Then("Click submit button")
	public void click_submit_button() {
		tp.clickBtn(tp.submit);
	}

	@Then("^Check that name is present in table (.+)")
	public void check_that_name_is_present_in_table(String fn) throws InterruptedException {
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.xpath("//div[contains(text(),\'"+ fn +"\')]")).getText(), fn);
	}
}