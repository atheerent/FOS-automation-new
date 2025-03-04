package stepsDefinitions.utils;

import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.aventstack.extentreports.gherkin.model.Scenario;

//import io.cucumber.core.api.Scenario;

//import cucumber.api.Scenario;
//import com.aventstack.extentreports.gherkin.model.Scenario;

public class Hooks {

    public WebDriver driver;
    public WebDriverWait wait;
    BrowserCommands browsercmd;
    AuthenticationControl authenticationControl;
    ElementActions elementActions;
    NavigationCommands navigationCommands;
    uploadActions uploadActions;
    ElementVerification elementVerification;

    public Hooks() {
        this.driver = DriverFactory.driver;
        this.driver = BrowserCommands.driver;
        //this.wait=DriverFactory.waitDriver(); //unused
    }

    @After("@prontoNavigationHook")
    public void openPronto() throws IOException {
        browsercmd = new BrowserCommands();
        navigationCommands = new NavigationCommands();

        browsercmd.maximize_the_browser();
        navigationCommands.navigate_to_page_of_pronto("ui/p/relationships/");

    }

    @Before("@adminLoginHook")
    public void login() throws IOException, InterruptedException, NullPointerException {
        authenticationControl = new AuthenticationControl();
        elementActions = new ElementActions();
        authenticationControl.enter_email_of_admin_user_in_field_of("EMAIL_FIELD", "loginPage");
        authenticationControl.enter_password_of_admin_in_field_of("PASSWORD_FIELD", "loginPage");
        elementActions.click_on_the_of("LOGIN_BUTTON", "loginPage");
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.BYTES);
            //	byte[] screenshotByte = FileUtils.readFileToByteArray(screenshotFile);
            scenario.attach(screenshot, "image/png", "image");
            //scenario.attach(screenshotByte, "image/png","image");
        }
    }
}
