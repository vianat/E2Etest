package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.CalendarPage;
import resources.base;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Test
public class CalendarTest extends base {

	CalendarPage cp = new CalendarPage(driver);
	String[] sendDate;
	String expected;

	@When("click on input [Date And Time]")
	public void clickOnInputDateAndTime() {
		cp.input.click();
	}

	@And("Generate first day of next mounth, next year, [15:00]")
	public void generateFirstDayOfNextMounthNextYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date nextMonthFirstDay = calendar.getTime();
		sendDate = nextMonthFirstDay.toString().split(" ");
		sendDate[3] = "15:00:00";
		sendDate[5] = "2023";
	}

	@And("Set in input")
	public void setInInput() {
		StringJoiner joiner = new StringJoiner(" ");
		for(int i = 0; i < sendDate.length; i++) {
			joiner.add(sendDate[i]);
		}
		String str = joiner.toString();

		cp.input.sendKeys(str);
		cp.input.sendKeys(Keys.ENTER);
	}

	@Then("Verify Date And Time equals setted date and time")
	public void verifyDateAndTimeEqualsSettedDateAndTime() throws InterruptedException {

		String actual = cp.input.getAttribute("value");
		assertEquals(actual, "December 1, 2023 3:00 PM");
	}

	@And("Clear input")
	public void clearInput() {
		cp.input.sendKeys(Keys.CONTROL, "a");
		cp.input.sendKeys(Keys.DELETE);
//		cp.input.clear();
	}
}