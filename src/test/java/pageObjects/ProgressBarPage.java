package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class ProgressBarPage extends base{

	@FindBy(xpath = "(//button[@id='startStopButton'])") public WebElement startandstopBtn;
	@FindBy(id = "resetButton") public WebElement resetBtn;
	@FindBy(xpath = "//div[@id='progressBar']") public WebElement progressmessage;

	public ProgressBarPage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
}