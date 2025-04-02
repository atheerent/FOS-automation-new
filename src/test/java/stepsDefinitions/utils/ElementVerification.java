package stepsDefinitions.utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.io.IOException;
import java.util.List;

public class ElementVerification {

    public WebDriver driver;
    public WebDriverWait wait;


    public ElementVerification() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    @Given("Verify presence of {string} of {string}")
    public void Verify_present_of_of(String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            System.out.println(locatorKey + " is visible on " + pageName);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not visible on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    @Given("Verify text of {string} of {string} is equal to {string}")
    public void Verify_text_of_of_is_equal(String locatorKey, String pageName, String Expected) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        Assert.assertEquals(element.getText(), Expected);
        System.out.println(element.getText() + " is visible which is equal to expected " + Expected);

    }

    @Given("Verify text of {string} of {string} contains {string}")
    public void Verify_text_of_of_contains(String locatorKey, String pageName, String Expected) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        Assert.assertTrue(element.getText().contains(Expected));
        System.out.println(element.getText() + " is visible which contains expected " + Expected);

    }

    @Given("Verify text present at {string} of {string}")
    public void Verify_text_present_at_of(String locatorKey, String pageName) throws IOException, InterruptedException {
        int temp = 0;
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        WebElement element = driver.findElement(By.xpath(locator));
        String elementText = "";
        while (elementText.length() == 0) {

            elementText = element.getText();
            System.out.println();
            Thread.sleep(500);
            temp++;
            if (temp >= 60) {
                break;
            }
        }
        Assert.assertTrue(elementText.length() != 0);

    }

    @Then("Verify the toast message {string} from {string} has {string} of {string}")
    public void verify_toast_message(String message, String toastPagename, String locatorKey, String locatorPagename) throws IOException, InterruptedException {
        String toastMessage = PropertyDriver.getPropertyData(message, toastPagename);
        String locator = PropertyDriver.getPropertyData(locatorKey, locatorPagename);
        Thread.sleep(3500); //will optimise later in next version
        WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        Assert.assertEquals(element.getText(), toastMessage);
        System.out.println("Message is displayed properly : " + element.getText());
    }

    @Then("Verify {string} of {string} does not contains {string}")
    public void verifyOfDoesNotContains(String locatorKey, String pageName, String Expected) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertFalse(elements.get(i).getText().contains(Expected));
        }
        System.out.print(Expected + " is not visible");
    }

    @Then("Verify absence of {string} of {string}")
    public void Verify_absent_of_of(String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        Assert.assertTrue("element is present on page ", elements.isEmpty());
        System.out.println(locator + " is not present on the page.");
    }

   /* @Then("wait until Page is fully loaded")
    public void waitUntilPageIsFullyLoaded() throws InterruptedException {
        DriverFactory.pageLoad();
    }*/

}
