package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class DragAndDrop extends base{

	@FindBy(id = "draggable") public WebElement el;
	@FindBy(id = "droppable") public WebElement box;

	public DragAndDrop(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}