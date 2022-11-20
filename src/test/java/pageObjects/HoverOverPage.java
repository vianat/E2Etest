package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;
public class HoverOverPage extends base{

	@FindBy(xpath = "//a[contains(text(),'Main Item 2')]") public WebElement mainItem;
	@FindBy(xpath = "//a[contains(text(),'SUB SUB LIST »')]") public WebElement SubList;
	@FindBy(xpath = "//a[contains(text(),'Sub Sub Item 1')]") public WebElement SubList2;

	public HoverOverPage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}