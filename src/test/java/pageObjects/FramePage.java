package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class FramePage extends base{

	public WebElement getFrame(String name) {
		if (name.equals("frame")) return frame;
		else return frame2;
	}

	@FindBy(id = "frame1") public WebElement frame;
	@FindBy(css = "#frame2") public WebElement frame2;

	public FramePage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}