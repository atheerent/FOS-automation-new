package stepsDefinitions.core.partnerOnboarding;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Then;
import stepsDefinitions.utils.DriverFactory;
import stepsDefinitions.utils.PropertyDriver;

public class partnerOnboardingStepDefinition {
    public WebDriver driver;
    public WebDriverWait wait;

    public partnerOnboardingStepDefinition() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }


    @Then("Fill the partner onboarding application")
    public String fill_the_applicant_information(DataTable dataTable) throws IOException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String locator = PropertyDriver.getPropertyData(row.get("FIELD_NAME"), "fillPartnerOnboardingApplication");
            String keyvalue = row.get("VALUE");
            System.out.println("Field name: " + locator + ", value: " + keyvalue);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(keyvalue);
        }
        return null;
    }
}

