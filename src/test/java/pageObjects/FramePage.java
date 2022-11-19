package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class FramePage extends base{

	public WebElement getFrame(String name) {
		if (name.equals("frame1")) return frame1;
		if(name.equals("child")) return child;
		return frame2;
	}

	@FindBy(id = "frame1") public WebElement frame1;
	@FindBy(id = "frame2") public WebElement frame2;
	@FindBy(tagName = "iframe") public WebElement child;

	public FramePage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}