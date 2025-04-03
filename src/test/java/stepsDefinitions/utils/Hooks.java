package stepsDefinitions.utils;

import java.io.IOException;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepsDefinitions.core.users.randomNameStepDefinitions;

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

    @After("@atheerNavigationHook")
    public void openAtheer() throws IOException {
        browsercmd = new BrowserCommands();
        navigationCommands = new NavigationCommands();

        browsercmd.maximize_the_browser();
        navigationCommands.navigate_to_page_of_atheer();

    }

    @Before("@SuperUserLoginHook")
    public void login() throws IOException, NullPointerException {
        authenticationControl = new AuthenticationControl();
        elementActions = new ElementActions();
        authenticationControl.enter_email_of_user_in_field_of("EMAIL_FIELD", "loginPage");
        authenticationControl.enter_password_of_user_in_field_of("PASSWORD_FIELD", "loginPage");
        elementActions.click_on_the_of("LOGIN_BUTTON", "loginPage");
    }

    @Before("@createUserHook")
    public void createUser() throws NullPointerException, IOException, InterruptedException {
        elementActions = new ElementActions();
        elementVerification = new ElementVerification();
        authenticationControl = new AuthenticationControl();
        randomNameStepDefinitions randomNameStepDefinitions = new randomNameStepDefinitions();
        browsercmd = new BrowserCommands();
        elementActions.click_on_the_of("CREATE_USER_NEW_BUTTON","userListingPage");
        elementActions.click_on_the_of("CREATE_NEW_BUTTON","userListingPage");
        elementVerification.Verify_present_of_of("POPUP_CREATE_NEW_TITLE","userListingPage");
        randomNameStepDefinitions.enter_random_real_name_username("LOGIN_FIELD","userListingPage");
        randomNameStepDefinitions.enter_random_real_name_username("FIRST_NAME_FIELD","userListingPage");
        elementActions.enter_random_name_in_of("LNAME","LAST_NAME_FIELD","userListingPage");
        elementActions.enter_random_email_alias_in_of("AtheerTest@atheerair.com","EMAIL_FIELD","userListingPage");
        authenticationControl.enter_password_of_user_in_field_of("PASSWORD_FIELD","userListingPage");
        authenticationControl.enter_password_of_user_in_field_of("CONFIRM_PASSWORD_FIELD","userListingPage");
        elementActions.click_on_the_of("SEND_NOTIFICATION_TOGGLE_BUTTON","userListingPage");
        elementActions.click_on_the_of("SAVE_BUTTON","userListingPage");
        browsercmd.waitForTime(5);
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
