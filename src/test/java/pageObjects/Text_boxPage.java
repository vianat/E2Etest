package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Text_boxPage  extends base{

	By userName = By.id("userName");
	By email = By.id("userEmail");
	By currentAddress = By.id("currentAddress");
	By permanentAddress = By.id("permanentAddress");
	By submitBtn = By.xpath("//button[@id='submit']");

	public Text_boxPage(WebDriver driver) {
		driver = base.driver;
	}
	public WebElement userName() {
		return driver.findElement(userName);
	}
	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement currentAddress() {
		return driver.findElement(currentAddress);
	}
	public WebElement permanentAddress() {
		return driver.findElement(permanentAddress);
	}
	public WebElement submitBtn() {
		return driver.findElement(submitBtn);
	}
}