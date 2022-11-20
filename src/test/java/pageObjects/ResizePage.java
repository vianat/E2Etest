package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class ResizePage extends base{

	@FindBy(xpath = "//div[@id='resizable']//span[@class='react-resizable-handle react-resizable-handle-se']") public WebElement el;

	public ResizePage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}