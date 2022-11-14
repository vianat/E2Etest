package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class TablePage  extends base{
	
	@FindBy(xpath ="//button[@id='addNewRecordButton']") public WebElement addBtn;
	@FindBy(xpath ="//input[@id='firstName']") public WebElement firstName;
	@FindBy(xpath ="//input[@id='lastName']") public WebElement lastName;
	@FindBy(xpath ="//input[@id='userEmail']") public WebElement userEmail;
	@FindBy(xpath ="//input[@id='age']") public WebElement age;
	@FindBy(xpath ="//input[@id='salary']") public WebElement salary;
	@FindBy(xpath ="//input[@id='department']") public WebElement department;
	@FindBy(xpath ="//button[@id='submit']") public WebElement submit;
	@FindBy(xpath ="//div[@role='dialog']") public WebElement dialog;
	
	public TablePage(WebDriver driver) {
		driver = base.driver;
		PageFactory.initElements(driver, this);
	}
	public  void insertText (WebElement el, String text) {
		el.sendKeys(text);
	}
	public void clickBtn (WebElement el) {
		el.click();
	}
	public WebElement getfirstName () {
		return firstName;
	}
}