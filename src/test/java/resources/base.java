package resources;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	public static WebDriver driver;
	
	public static WebDriver navigateTo(WebDriver driver, String url) {
		driver.get(url);
		return driver;
	}
	public static void waitUntilElementToAppear(WebDriver driver, WebElement el){
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) el));
	}
	public static void waitUntilElementToDisAppear(WebDriver driver, WebElement el){
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	public static void mouseClickOnElement(WebDriver driver, WebElement element) {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(element).click().perform();
	}
}