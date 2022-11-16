package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class WindowsPage extends base{
	
	@FindBy(id = "tabButton") public WebElement tabBtn;
	@FindBy(css = "#windowButton") public WebElement windowBtn;
	@FindBy(id = "messageWindowButton") public WebElement messageBtn;
	
	public WindowsPage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}