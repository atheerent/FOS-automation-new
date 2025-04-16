package stepsDefinitions.core.contents;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepsDefinitions.utils.DriverFactory;
import stepsDefinitions.utils.PropertyDriver;
import stepsDefinitions.utils.searchContext;

import java.io.IOException;

public class randomContentNameStepDefinitions {

    public WebDriver driver;
    public WebDriverWait wait;
    private static final Faker faker = new Faker(); // Faker instance

    public randomContentNameStepDefinitions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    @Then("Enter a random name with {string} in {string} field on {string}")
    public void enter_random_name(String contentFormat, String locatorKey, String pageName) throws IOException {
        // Generate a unique real name username using Faker
        String randomContentName = generateUniqueRealName();
        System.out.println("Generated Unique Real Name Username: " + randomContentName);
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        searchContext.setContext("lastGeneratedContentName", randomContentName);

        // Locate the input field and enter the generated name
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(randomContentName + contentFormat);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    @Then("Enter a random text in {string} field on {string}")
    public void enter_random_name(String locatorKey, String pageName) throws IOException {
        // Generate a unique real name username using Faker
        String randomText = generateUniqueText();
        System.out.println("Generated Unique text : " + randomText);
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        // Locate the input field and enter the generated name
        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.sendKeys(randomText);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }

    @Then("Enter a random URL in {string} field on {string}")
    public void enter_random_url(String locatorKey, String pageName) throws IOException {
        // Generate a random URL using Faker
        String randomUrl = generateRandomUrl();
        System.out.println("Generated Random URL: " + randomUrl);
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);

        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            element.clear(); // optional, to ensure no previous text
            element.sendKeys(randomUrl);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }
    public static String generateUniqueRealName() {
        String word1 = faker.artist().name().replaceAll("\\s+", "");
        String word2 = faker.weather().description().replaceAll("\\s+", "");
        return word1 + word2;
    }

    public static String generateRandomUrl() {
        String domain = faker.internet().domainWord().replaceAll("\\s+", "").toLowerCase();
        String tld = faker.internet().domainSuffix(); // like com, net, org
        return "https://www." + domain + "." + tld;
    }

    public static String generateUniqueText() {
        StringBuilder paragraph = new StringBuilder();
        int wordCount = 0;

        while (wordCount < 200) {
            String intro = "In recent discussions, ";
            String author = faker.book().author();
            String book = faker.book().title();
            String company = faker.company().name();
            String catchPhrase = faker.company().catchPhrase();
            String quote = faker.harryPotter().quote();
            String city = faker.address().city();
            String job = faker.job().title();
            String buzzword = faker.company().buzzword();

            String combinedSentence = intro + author + " mentioned the book \"" + book +
                    "\" during a panel at " + company + " in " + city +
                    ". The discussion highlighted concepts like \"" + catchPhrase +
                    "\", often used by " + job + "s when referring to \"" + buzzword + "\". " +
                    "One memorable quote was: \"" + quote + "\" ";

            paragraph.append(combinedSentence).append(" ");
            wordCount += combinedSentence.split("\\s+").length;
        }

        return paragraph.toString().trim();
    }


    @Then("Search for the random content in {string} of {string}")
    public void search_for_content(String locatorKey, String pageName) throws IOException {
        String randomContentName = searchContext.getContext("lastGeneratedContentName");

        if (randomContentName == null) {
            throw new IllegalStateException("No search term has been generated yet.");
        }

        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);

        try {
            this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement searchBox = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            searchBox.sendKeys(randomContentName);
            searchBox.sendKeys(Keys.ENTER); // Simulating search action
            System.out.println("Searching for: " + randomContentName);
        } catch (TimeoutException e) {
            System.out.println(locatorKey + " is not present on " + pageName);
            e.printStackTrace();
            throw e;
        }
    }
}