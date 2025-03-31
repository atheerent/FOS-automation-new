package stepsDefinitions.utils;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties property;
    public static String pageLoadStatus = "abc";
    public static JavascriptExecutor jWait;

    String isHeadless = "false";

    public void getWebDriver(String browserName) throws IOException {
        isHeadless = PropertyDriver.getPropertyConfig("HEADLESS");

        switch (browserName.toLowerCase()) {
            case "browser":
                browserName = PropertyDriver.getPropertyConfig("BROWSER");
                switch (browserName.toLowerCase()) {
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "safari":
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                        break;
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeoptions = getChromeOptions();
                        driver = new ChromeDriver(chromeoptions);
                        break;
                }
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeoptions = new ChromeOptions();
                if (isHeadless.equalsIgnoreCase("true")) {
                    chromeoptions.addArguments("--headless");
                }
                chromeoptions.addArguments("--no-sandbox");
                chromeoptions.addArguments("--window-position=0,0");
                chromeoptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeoptions);
                break;
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeoptions = new ChromeOptions();
        if (isHeadless.equalsIgnoreCase("true")) {
            chromeoptions.addArguments("--headless");
            chromeoptions.addArguments("--no-sandbox");
            chromeoptions.addArguments("--window-position=0,0");
            chromeoptions.addArguments("--remote-allow-origins=*");
            chromeoptions.addArguments("--incognito");
        }
        chromeoptions.addArguments("--no-sandbox");
        chromeoptions.addArguments("--window-position=0,0");
        chromeoptions.addArguments("--window-size=2560,1440");
        chromeoptions.addArguments("--remote-allow-origins=*");
        chromeoptions.addArguments("--incognito");
        return chromeoptions;
    }

    public static WebDriverWait waitDriver() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }
}
