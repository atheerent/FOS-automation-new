/*
 *  Scenario: Authentication scnearios
    Given Enter email of admin user in "elementName" field of "pageName"
    Then Enter password of admin in "password" field of "pageName"
    Then Enter email of non-admin user in "username" field of "pageName"
    Then Enter password of non-admin user in "password" field of "pageName"
 */

package stepsDefinitions.utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AuthenticationControl {

    public WebDriver driver;
    public WebDriverWait wait;

    public AuthenticationControl() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    @Given("Enter email of admin user in {string} field of {string}")
    public void enter_email_of_admin_user_in_field_of(String locatorKey, String pageName) throws IOException {
        String email = PropertyDriver.getPropertyConfig("USERNAME");
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(email);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }

    }

    @Then("Enter password of admin in {string} field of {string}")
    public void enter_password_of_admin_in_field_of(String locatorKey, String pageName) throws IOException {
        String password = PropertyDriver.getPropertyConfig("PASSWORD");
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        try {
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(password);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

}
