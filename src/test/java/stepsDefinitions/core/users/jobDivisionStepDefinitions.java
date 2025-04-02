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

public class jobDivisionStepDefinitions {

    public WebDriver driver;
    public WebDriverWait wait;

    public jobDivisionStepDefinitions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    private static final String[] JOB_DIVISIONS = {
            "Software Development", "Quality Assurance", "Project Management", "Human Resources",
            "Marketing", "Sales", "Finance", "Customer Support", "IT Infrastructure",
            "Research and Development", "Product Management", "Operations", "Cybersecurity",
            "Legal", "Supply Chain Management"
    };

    @Then("Enter a random job division in {string} field on {string}")
    public void enter_random_job_division(String locatorKey, String pageName) throws IOException {
        // Generate a job division dynamically
        String randomJobDivision = generateRandomJobDivision();
        System.out.println("Generated Job Division: " + randomJobDivision);
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);

        // Get the locator for the input field
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(randomJobDivision);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    public static String generateRandomJobDivision() {
        Random random = new Random();
        return JOB_DIVISIONS[random.nextInt(JOB_DIVISIONS.length)];
    }
}