package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/Features", glue = { "StepDefinitions" },
monochrome=true,
plugin= {"pretty", "html:target/htmlReports/report.html",
		"json:target/JsonReports/report.json",
		"junit:target/JunitReports/report.xml"},

tags="@smokeTest")


public class TestRunner {

}
