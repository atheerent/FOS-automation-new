/*
	Scenario: Element actions
	Given Enter "text" in "elementName" of "pageName"
	Then Click on the "elementName" of "pageName"
	Then Select option by text from "dropdownElement" element of "pageName" : "dropdownValue"
	Then Select option by index from "dropdownElement" element of "pageName" : "indexNumber"
	Then Hover on "elementName" element of "pageName"
 */
package stepsDefinitions.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ElementActions {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor executor;
    String isHcaptcha = "false";

    public ElementActions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    @Given("Enter {string} in {string} of {string}")
    public void enter_in_of(String text, String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(text);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    //Use this snippet if you need any input with timestamp.
    @Given("Enter {string} with timestamp in {string} of {string}")
    public void enter_with_timestamp_in_of(String text, String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(text + " (" + date + ")");
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    @Then("Enter random email alias of {string} of {string} of {string}")
    public void enter_random_email_alias_in_of(String text, String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        String[] parts = text.split("@");
        String generatedString = RandomStringUtils.randomNumeric(3);
        String email_address = parts[0] + "+" + generatedString + "@" + parts[1];
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(email_address);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    @Then("Click on the {string} of {string}")
    public void click_on_the_of(String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);

            this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            WebElement element = driver.findElement(By.xpath(locator));
            element.click();

    }

    //To clear text from field.
    @Then("Clear the {string} from {string}")
    public void clear_the_from(String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.DELETE);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    @Then("Select option by text from {string} element of {string} : {string}")
    public void select_option_by_text_from_element_of(String locatorKey, String pageName, String optionValue) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        try {
            WebElement dropdownElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue(optionValue);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    @Then("Select option by index from {string} element of {string} : {string}")
    public void select_option_by_index_from_element_of(String index, String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        try {
            WebElement dropdownElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByIndex(Integer.parseInt(index));
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    @Then("Hover on {string} element of {string}")
    public void hover_on_element_of(String locatorKey, String pageName) throws InterruptedException, IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        Actions actions = new Actions(this.driver);
        try {
            WebElement mouseHover = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            actions.moveToElement(mouseHover).perform();
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    @Then("Drag an element from {string} and drop it to {string} of {string} page")
    public void drag_an_element_from_and_drop_it_to_of_page(String sourceElementKey, String destinationElementKey, String pageName) throws IOException {
        String sourceLocatorString = PropertyDriver.getPropertyData(sourceElementKey, pageName);
        String destinationLocatorString = PropertyDriver.getPropertyData(destinationElementKey, pageName);
        Actions actions = new Actions(this.driver);
        WebElement sourceLocator;
        try {
            sourceLocator = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sourceLocatorString)));
        } catch (TimeoutException e) {
            System.out.println(sourceElementKey + "(Source Element) is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
        WebElement destinationLocator;
        try {
            destinationLocator = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(destinationLocatorString)));
        } catch (TimeoutException e) {
            System.out.println(destinationElementKey + "(Destination Element) is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
        actions.dragAndDrop(sourceLocator, destinationLocator);
    }

    @Then("Click on expand or collapse {string} from {string}")
    public void click_on_expand_or_collapse_from(String locatorKey, String pageName) throws IOException, InterruptedException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = driver.findElement(By.xpath(locator));
            this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            element.click();

        } catch (StaleElementReferenceException | ElementNotInteractableException | IllegalArgumentException |
                 NoSuchElementException e) {
            executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();",
                    this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))),
                    ExpectedConditions.presenceOfElementLocated(By.xpath(locator)),
                    ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }

        Thread.sleep(1500);
    }

}
