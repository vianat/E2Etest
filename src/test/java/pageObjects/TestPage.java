package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class TestPage extends BasePage implements Page {

	private HashMap<String, WebElement> map = new HashMap<>();

	@FindBy(id = "frame1") public WebElement frame1;

	public TestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		initMap();
	}

	@Override
	public void initMap() {
		map.put("frame1", frame1);
	}

	public WebElement getFrame(String name) {
		return frame1;
	}
}