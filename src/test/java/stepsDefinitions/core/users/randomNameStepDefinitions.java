package stepsDefinitions.core.users;

import com.github.javafaker.Faker;
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

public class randomNameStepDefinitions {

    public WebDriver driver;
    public WebDriverWait wait;
    private static final Faker faker = new Faker(); // Faker instance

    public randomNameStepDefinitions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    @Then("Enter a random real name username in {string} field on {string}")
    public void enter_random_real_name_username(String locatorKey, String pageName) throws IOException {
        // Generate a unique real name username using Faker
        String uniqueRealName = generateUniqueRealName();
        System.out.println("Generated Unique Real Name Username: " + uniqueRealName);
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);

        // Locate the input field and enter the generated name
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(uniqueRealName);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    public static String generateUniqueRealName() {
        return faker.name().firstName() + faker.name().lastName(); // Generates a unique full name without spaces
    }
}