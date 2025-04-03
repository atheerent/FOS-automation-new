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
import stepsDefinitions.utils.searchContext;

import java.io.IOException;
import java.util.Random;

public class randomPhoneNumberStepDefinitions {
    public WebDriver driver;
    public WebDriverWait wait;

    public randomPhoneNumberStepDefinitions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    @Then("Enter random phone number of {string} of {string}")
    public void enter_random_phone_number_in_of(String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        // Generate a random phone number in the format XXX-XXX-XXXX
        String randomPhoneNumber = generateRandomPhoneNumber();
        searchContext.setContext("lastGeneratedPhoneNumber", randomPhoneNumber);
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(randomPhoneNumber);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    // Method to generate a random phone number
    private String generateRandomPhoneNumber() {
        Random random = new Random();
        int areaCode = 100 + random.nextInt(900); // Area code between 100 and 999
        int centralOfficeCode = 100 + random.nextInt(900); // Central office code between 100 and 999
        int lineNumber = 1000 + random.nextInt(9000); // Line number between 1000 and 9999

        return String.format("%03d-%03d-%04d", areaCode, centralOfficeCode, lineNumber);
    }

}
