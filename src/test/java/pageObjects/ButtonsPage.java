package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class ButtonsPage extends base{
	
	@FindBy(xpath = "(//button[normalize-space()='Click Me'])[1]") public WebElement clickMeBtn;
	@FindBy(css = "#rightClickBtn") public WebElement rightClickBtn;
	@FindBy(id = "doubleClickBtn") public WebElement doubleClickBtn;
	
	@FindBy(xpath = "//p[@id='dynamicClickMessage']") public WebElement dynamicClickMessage;
	@FindBy(id = "rightClickMessage") public WebElement rightClickMessage;
	@FindBy(id = "doubleClickMessage") public WebElement doubleClickMessage;
	
	public ButtonsPage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}