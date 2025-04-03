package stepsDefinitions.core.users;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepsDefinitions.utils.DriverFactory;
import stepsDefinitions.utils.PropertyDriver;

import java.io.IOException;
import java.util.Random;

public class jobDescriptionStepDefinitions {

    public WebDriver driver;
    public WebDriverWait wait;

    public jobDescriptionStepDefinitions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    private static final String[] JOB_DESCRIPTIONS = {
            "Develops and maintains software.",
            "Designs test cases for software quality.",
            "Leads project teams for business growth.",
            "Analyzes data for decision-making.",
            "Manages server infrastructure reliability.",
            "Creates user manuals and documentation.",
            "Optimizes company operations strategies.",
            "Handles financial planning and management.",
            "Designs user-friendly interfaces.",
            "Implements security measures for data."
    };

    @Then("Enter a random job description in {string} field on {string}")
    public void enter_random_job_description(String locatorKey, String pageName) throws IOException {
        // Generate a job description dynamically
        String randomJobDescription = generateRandomJobDescription();
        System.out.println("Generated Job Description: " + randomJobDescription);
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);

        // Get the locator for the input field
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(randomJobDescription);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    public static String generateRandomJobDescription() {
        Random random = new Random();
        return JOB_DESCRIPTIONS[random.nextInt(JOB_DESCRIPTIONS.length)];
    }
}