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

public class JobTitleStepDefinitions {

    public WebDriver driver;
    public WebDriverWait wait;

    public JobTitleStepDefinitions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    private static final String[] JOB_TITLES = {
            "Software Engineer", "QA Engineer", "Product Manager", "Data Scientist",
            "Business Analyst", "DevOps Engineer", "Project Manager", "HR Specialist",
            "Marketing Coordinator", "Financial Analyst", "Technical Writer",
            "Cloud Engineer", "Security Analyst", "UX Designer", "Database Administrator"
    };

    @Then("Enter a random job title in {string} field on {string}")
    public void enter_random_job_title(String locatorKey, String pageName) throws IOException {
        // Generate a job title dynamically
        String randomJobTitle = generateRandomJobTitle();
        System.out.println("Generated Job Title: " + randomJobTitle);
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);

        // Get the locator for the input field
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(randomJobTitle);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    public static String generateRandomJobTitle() {
        Random random = new Random();
        return JOB_TITLES[random.nextInt(JOB_TITLES.length)];
    }
}

