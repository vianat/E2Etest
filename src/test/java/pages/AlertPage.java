package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class AlertPage extends base{
	
	@FindBy(id = "alertButton") public WebElement alertBtn;
	@FindBy(id = "timerAlertButton") public WebElement timerBtn;
	@FindBy(id = "confirmButton") public WebElement confirmBtn;
	@FindBy(id = "promtButton") public WebElement promtBtn;
	
	public AlertPage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}