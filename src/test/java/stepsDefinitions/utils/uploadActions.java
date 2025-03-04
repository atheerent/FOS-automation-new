package stepsDefinitions.utils;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import io.cucumber.java.en.Given;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class uploadActions {
    public WebDriver driver;
    public WebDriverWait wait;

    public uploadActions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

    @Given("Import a file {string} from {string} of page {string}")
    public void import_a_file_from_of_page(String text, String locatorKey, String pageName) throws IOException, InterruptedException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        String ProjectPath = System.getProperty("user.dir");
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1).build();
        S3Object s3object = s3client.getObject("bhavesh-aws-test", text);
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        FileUtils.copyInputStreamToFile(inputStream, new File(ProjectPath + "/src/test/java/resources/importFiles/" + text));

        WebElement element = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        Thread.sleep(3500);
        element.sendKeys(ProjectPath + "/src/test/java/resources/importFiles/" + text);
    }

    @Given("Import a folder {string} with files from {string} of page {string}")
    public void import_a_folder_from_of_page(String text, String locatorKey, String pageName) throws IOException, InterruptedException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        String ProjectPath = System.getProperty("user.dir");
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1).build();
        S3Object s3object = s3client.getObject("bhavesh-aws-test", text);
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        FileUtils.copyInputStreamToFile(inputStream, new File(ProjectPath + "/src/test/java/resources/importFiles/" + text));

        WebElement element = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        Thread.sleep(2500);
        element.sendKeys(ProjectPath + "/src/test/java/resources/importFiles/");
    }
}
