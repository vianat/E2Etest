package steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import pages.ResizePage;
import resources.base;
import java.awt.*;

public class MouseMoveTest extends base {
	
	ResizePage rp = new ResizePage(driver);

	@When("Click and hold")
	public void click_and_hold() {
		Actions actions = new Actions(driver);
		actions.moveToElement(rp.el);
		actions.clickAndHold().perform();
	}

	@And("Move to coordinate {int} and {int}")
	public void moveToCoordinateAnd(int x, int y) throws AWTException {
		Actions actions = new Actions(driver);
		Point coordinates = driver.findElement(By.xpath("//div[@id='resizable']//span[@class='react-resizable-handle react-resizable-handle-se']")).getLocation();
		Robot robot = new Robot();
		robot.mouseMove(coordinates.getX()+x,coordinates.getY()+y);
		actions.click().build().perform();
	}

	@Then("Drop")
	public void drop() {
		new Actions(driver).click().build().perform();
	}
}