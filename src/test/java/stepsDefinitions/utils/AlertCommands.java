/* 
    Scenario: Handling alerts
    Given Cancel an alert
    Then Accept an alert
 */


package stepsDefinitions.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AlertCommands {

    public WebDriver driver;
    public WebDriverWait wait;

    public AlertCommands() {
        this.driver = DriverFactory.driver;
        //this.wait=DriverFactory.waitDriver(); //unused
    }

    @Given("Cancel an alert")
    public void cancel_an_alert() {
        this.driver.switchTo().alert().dismiss();
    }

    @Then("Accept an alert")
    public void accept_an_alert() {
        this.driver.switchTo().alert().accept();
    }


}
