package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class CalendarPage extends base{

	@FindBy(id = "dateAndTimePickerInput") public WebElement input;
	@FindBy(xpath = "//div[@class='react-datepicker__year-read-view']") public WebElement yearList;

	public CalendarPage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}