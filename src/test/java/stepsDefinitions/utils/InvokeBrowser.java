package stepsDefinitions.utils;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class InvokeBrowser {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Given("Invoke {string} browser")
    public void invoke_browser(String browserName) throws IOException {
        DriverFactory factory = new DriverFactory();
        factory.getWebDriver(browserName);
    }

}
