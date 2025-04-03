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

public class jobDepartmentStepDefinitions {

    public WebDriver driver;
    public WebDriverWait wait;

    public jobDepartmentStepDefinitions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    private static final String[] JOB_DEPARTMENTS = {
            "Engineering", "Quality Assurance", "Product Management", "Human Resources",
            "Marketing", "Sales", "Finance", "Customer Support", "IT Services",
            "Research and Development", "Operations", "Legal", "Cybersecurity",
            "Supply Chain Management", "Public Relations"
    };

    @Then("Enter a random job department in {string} field on {string}")
    public void enter_random_job_department(String locatorKey, String pageName) throws IOException {
        // Generate a job department dynamically
        String randomJobDepartment = generateRandomJobDepartment();
        System.out.println("Generated Job Department: " + randomJobDepartment);
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);

        // Get the locator for the input field
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(randomJobDepartment);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    public static String generateRandomJobDepartment() {
        Random random = new Random();
        return JOB_DEPARTMENTS[random.nextInt(JOB_DEPARTMENTS.length)];
    }
}