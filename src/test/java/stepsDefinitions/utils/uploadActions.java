package stepsDefinitions.utils;

import io.cucumber.java.en.Given;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class uploadActions {
    public WebDriver driver;
    public WebDriverWait wait;

    public uploadActions() {
        this.driver = DriverFactory.driver;
        this.wait = DriverFactory.waitDriver();
    }

//    @Given("Import a file {string} from {string} of page {string}")
//    public void import_a_file_from_of_page(String text, String locatorKey, String pageName) throws IOException, InterruptedException {
//        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
//        String ProjectPath = System.getProperty("user.dir");
//
//        S3Client s3Client = S3Client.builder()
//                .region(Region.AP_SOUTH_1)
//                .build();
//
//        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
//                .bucket("bhavesh-aws-test")
//                .key(text)
//                .build();
//
//        ResponseInputStream<GetObjectResponse> s3ObjectStream = s3Client.getObject(getObjectRequest);
//        FileUtils.copyInputStreamToFile(s3ObjectStream, new File(ProjectPath + "/src/test/java/resources/importFiles/" + text));
//
//        WebElement element = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
//        Thread.sleep(3500);
//        element.sendKeys(ProjectPath + "/src/test/java/resources/importFiles/" + text);
//
//        s3Client.close(); // (optional good practice)
//    }

    @Given("Import a file {string} from {string} of page {string}")
    public void import_a_file_from_of_page(String text, String locatorKey, String pageName) throws IOException, InterruptedException {
        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
        String projectPath = System.getProperty("user.dir");

        // Construct the public S3 file URL
        String fileUrl = "https://bhavesh-aws-test.s3.ap-south-1.amazonaws.com/" + text;

        // Download the file from public URL
        File targetFile = new File(projectPath + "/src/test/java/resources/importFiles/" + text);
        FileUtils.copyURLToFile(new URL(fileUrl), targetFile);

        // Locate and interact with the element
        WebElement element = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        Thread.sleep(3500); // You can fine-tune/remove this wait if needed
        element.sendKeys(targetFile.getAbsolutePath());
    }

//    @Given("Import a folder {string} with files from {string} of page {string}")
//    public void import_a_folder_from_of_page(String text, String locatorKey, String pageName) throws IOException, InterruptedException {
//        String locator = PropertyDriver.getPropertyData(locatorKey, pageName);
//        String ProjectPath = System.getProperty("user.dir");
//        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1).build();
//        S3Object s3object = s3client.getObject("bhavesh-aws-test", text);
//        S3ObjectInputStream inputStream = s3object.getObjectContent();
//        FileUtils.copyInputStreamToFile(inputStream, new File(ProjectPath + "/src/test/java/resources/importFiles/" + text));
//
//        WebElement element = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
//        Thread.sleep(2500);
//        element.sendKeys(ProjectPath + "/src/test/java/resources/importFiles/");
//    }
}
