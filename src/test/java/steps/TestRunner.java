package steps;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps"},
        monochrome = false,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/htmlReports/report.html",
                "json:target/JsonReports/report.json",
                "junit:target/JunitReports/report.xml"},

        tags = "@api")
public class TestRunner {}