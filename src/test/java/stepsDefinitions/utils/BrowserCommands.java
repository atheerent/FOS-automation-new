/*  Feature Steps:
Scenario: Browser Commands [Open/Quit/Close browser]
    Given Invoke "chrome" browser
    Then Quit the browser
    Then Close the current browser window
    Then Delete browser cookies
    Then Maximize the browser
    Then Refresh the current browser window
    Then Hard refresh the current browser window
*/

package stepsDefinitions.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserCommands {

    public static WebDriver driver;
    public WebDriverWait wait;

    public BrowserCommands() {
        driver = DriverFactory.driver;
        driver = BrowserCommands.driver;
        //this.wait=DriverFactory.waitDriver(); //unused
    }

    @Then("Quit the browser")
    public void quit_the_browser() {
        driver.quit();
    }

    @Then("Wait for a while")
    public void wait_for_a_while() {
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

    }

    @Then("Close the current browser window")
    public void close_the_current_browser_window() {
        driver.close();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            break;
        }
    }

    @Then("Delete browser cookies")
    public void delete_browser_cookies() {
        driver.manage().deleteAllCookies();
    }

    @Then("Maximize the browser")
    public void maximize_the_browser() {
        //this.driver.manage().window().maximize();
        //This code has now been moved under DriverFactory.java as ChromeOptions argument
        //REASON: Manually maximizing it doesn't work with Jenkins
    }

    @Then("Refresh the current browser window")
    public void refresh_the_current_browser_window() {
        driver.navigate().refresh();
    }


    @Then("Hard refresh the current browser window")
    public void hard_refresh_the_current_browser_window() {
        // WIP
        driver.navigate().refresh();
    }

    @Then("Press Enter key")
    public void pressEnterKey() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("Scroll up")
    public void scrollUP_window() {
        // WIP
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,-500)");
    }

    @Then("Scroll down")
    public void scrollDOWN_window() {
        // WIP
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,500)");
    }

    @Then("Scroll to {string} element from {string}")
    public void scroll_to_element(String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        WebElement element = driver.findElement(By.xpath(locator));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }

    @Then("Open the new tab and enter url {string} of {string}")
    public void open_new_tab_and_enter_url(String locatorKey, String pageName) throws IOException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        WebElement element = driver.findElement(By.xpath(locator));
        String URL = element.getAttribute("innerHTML");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(URL);
    }

    @Then("Wait for {int} seconds")
    public void waitForTime(int A) throws InterruptedException {
        Thread.sleep(A*1000);
    }
}


