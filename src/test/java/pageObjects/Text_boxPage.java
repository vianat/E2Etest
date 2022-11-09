package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Text_boxPage {

	public WebDriver driver;

	By userName = By.id("userName");
	By email = By.id("userEmail");
	By currentAddress = By.id("currentAddress");
	By permanentAddress = By.id("permanentAddress");
	By submitBtn = By.id("submit");

	public Text_boxPage(WebDriver driver) {
		this.driver = driver;
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