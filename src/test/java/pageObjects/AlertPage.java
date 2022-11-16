package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class AlertPage extends base{
	
	@FindBy(id = "tabButton") public WebElement tabBtn;
	@FindBy(id = "tabButton") public WebElement tabBtn3;
	
	@FindBy(css = "#windowButton") public WebElement windowBtn;
	@FindBy(id = "tabButton") public WebElement tabBtn2;
	@FindBy(id = "messageWindowButton") public WebElement messageBtn;
	
	@FindBy(css = "#windowButton") public WebElement windowBtn1;
	
	
	public AlertPage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}