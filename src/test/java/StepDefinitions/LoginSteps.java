package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Date currentdate=new Date();
		String screenshotFilename=currentdate.toString().replace(" ", "-").replace(":", "-");
		
		driver.navigate().to("https://www.google.com/travel/flights");
		Thread.sleep(4000);
		File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("target/ScreenShots/"+screenshotFilename+".png"));
		System.out.println(driver.getTitle());
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		System.out.println("Inside step- enters username and password");
	}

	@When("clicks login button")
	public void clicks_login_button() {
		System.out.println("Inside step- clicks login button");
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Inside step- navigates to home page");
	}
}