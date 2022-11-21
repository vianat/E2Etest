package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Check_boxPage  extends base{

	By toggle = By.xpath("//button[@title='Toggle']");
	By home = By.xpath("//span[@class='rct-checkbox']//*[name()='svg']");
	By response = By.id("result");
	
	public Check_boxPage(WebDriver driver) {
		driver = base.driver;
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