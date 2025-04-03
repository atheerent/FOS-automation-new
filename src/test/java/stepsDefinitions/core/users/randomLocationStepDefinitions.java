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

public class randomLocationStepDefinitions {

    public WebDriver driver;
    public WebDriverWait wait;

    public randomLocationStepDefinitions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    private static final String[] LOCATIONS = {
            "New York, USA", "Los Angeles, USA", "Toronto, Canada", "London, UK",
            "Berlin, Germany", "Paris, France", "Tokyo, Japan", "Sydney, Australia",
            "Dubai, UAE", "Singapore, Singapore", "Mumbai, India", "São Paulo, Brazil",
            "Cape Town, South Africa", "Beijing, China", "Moscow, Russia"
    };

    @Then("Enter a random location in {string} field on {string}")
    public void enter_random_location(String locatorKey, String pageName) throws IOException {
        // Generate a location dynamically
        String randomLocation = generateRandomLocation();
        System.out.println("Generated Location: " + randomLocation);
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);

        // Get the locator for the input field
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(randomLocation);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    public static String generateRandomLocation() {
        Random random = new Random();
        return LOCATIONS[random.nextInt(LOCATIONS.length)];
    }
}