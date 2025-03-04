/*
 * Scenario: Navigation commands
    Given Navigate to "url" page
    Then Navigate to "sub_directory" page of Pronto
    Then Click on forward button in the browser window
    Then Click on back button in the browser window
 */


package stepsDefinitions.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class NavigationCommands {

    public WebDriver driver;
    public WebDriverWait wait;

    public NavigationCommands() {
        this.driver = DriverFactory.driver;
        //this.wait=DriverFactory.waitDriver(); //unused

    }

    @Given("Navigate to {string} page")
    public void navigate_to_page(String url) {
        this.driver.navigate().to(url);

    }

    @Given("Navigate to {string} page of Pronto")
    public void navigate_to_page_of_pronto(String sub_directory) throws IOException {
        String instance = PropertyDriver.getPropertyConfig("INSTANCE");
        System.out.println("INSTANCE" + instance);
        String url = "https://" + instance + ".atheer.io/signin";
        System.out.println(" MAIN URL " + url);
        this.driver.navigate().to(url);

    }
    @Then("Click on forward button in the browser window")
    public void click_on_forward_button_in_the_browser_window() {
        this.driver.navigate().forward();
    }

    @Then("Click on back button in the browser window")
    public void click_on_back_button_in_the_browser_window() {
        this.driver.navigate().back();
    }

    @Then("Navigate to {string} page {string} of Pronto") // To fetch Sub-directory URL provided in the properties file
    public void navigate_to_page_of_pronto(String sub_directory, String pageName) throws IOException {
        String sub_url = PropertyDriver.getPropertyData(sub_directory, pageName);
        String instance = PropertyDriver.getPropertyConfig("INSTANCE");
        String url = "https://" + instance + ".atheer.io/signin";
        this.driver.navigate().to(url);
    }
}
