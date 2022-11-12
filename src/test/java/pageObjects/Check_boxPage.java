package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Check_boxPage {

	public WebDriver driver = null;

	By toggle = By.xpath("//button[@title='Toggle']");
	By home = By.xpath("//span[@class='rct-checkbox']");
	By response = By.id("result");
	
	public Check_boxPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement toggle() {
		return driver.findElement(toggle);
	}
	public WebElement home() {
		return driver.findElement(home);
	}
	public WebElement hometxt() {
		return driver.findElement(response);
	}
}