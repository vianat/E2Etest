package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class AlertPage extends base{
	
	@FindBy(xpath = "//button[@id='alertButton']") public WebElement alertBtn;
	@FindBy(xpath = "//button[@id='timerAlertButton']") public WebElement timerBtn;
	@FindBy(xpath = "//button[@id='confirmButton']") public WebElement confirmBtn;
	@FindBy(xpath = "//button[@id='promtButton']") public WebElement promtBtn;
	
	public AlertPage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}