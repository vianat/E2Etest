package StepDefinitions;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.AbstractReadOnlyAdapter;
import pageObjects.Text_boxPage;
import resources.base;

public class TextBoxSteps extends base {

	@Given("^Enters (.+),(.+),(.+),(.+) in text-boxes$")
	public void fill_all_dataFields(String uName, String email, String cAddress, String pAddress) throws Throwable {

		base.navigateTo(driver, "http://demoqa.com/text-box");
		Text_boxPage tp = new Text_boxPage(driver);
		tp.userName().sendKeys(uName);
		tp.email().sendKeys(email);
		tp.currentAddress().sendKeys(cAddress);
		tp.permanentAddress().sendKeys(pAddress);
		tp.submitBtn().click();
		Thread.sleep(1000);
	}
	
	@Then("^Verify that (.+),(.+),(.+),(.+) are presents in response")
	public void verify_data(String uName, String email, String cAddress, String pAddress) throws Throwable {
		
		String UN = driver.findElement(By.id("name")).getText().split(":")[1];
		String EM = driver.findElement(By.id("email")).getText().split(":")[1];
		String CA = driver.findElement(By.xpath("(//*[@id='currentAddress'])[2]")).getText().split(":")[1];
		String PA = driver.findElement(By.xpath("(//*[@id='permanentAddress'])[2]")).getText().split(":")[1];
		
		assertEquals(UN, uName);
		assertEquals(EM, email);
		assertEquals(CA, cAddress);
		assertEquals(PA, pAddress);
	}
}