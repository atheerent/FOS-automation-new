package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/features/core/",
        plugin = {"pretty",
                "html:test-output/reports/cucumber-reports/htmlReport.html",
                "json:test-output/reports/cucumber-reports/jsonReport.json",
                "junit:test-output/reports/cucumber-reports/xmlReport.xml",
                "rerun:test-output/failed_scenarios.text",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = "stepsDefinitions",
        dryRun = false,
        monochrome = true,
        tags = "@users", //can use AND , OR, NOT conditions
        stepNotifications = true)

public class testRunner {


}