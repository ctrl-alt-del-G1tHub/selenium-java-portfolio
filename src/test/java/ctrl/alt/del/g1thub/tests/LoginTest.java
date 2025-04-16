package ctrl.alt.del.g1thub.tests;

import ctrl.alt.del.g1thub.pages.LoginPage;
import ctrl.alt.del.g1thub.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for login functionality
 * This class demonstrates how to create a basic test using the Page Object Model
 */
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    
    // You would normally store these in a properties file or use a data provider
    private static final String TEST_URL = "https://the-internet.herokuapp.com/login";
    private static final String VALID_USERNAME = "tomsmith";
    private static final String VALID_PASSWORD = "SuperSecretPassword!";
    private static final String INVALID_USERNAME = "wronguser";
    private static final String INVALID_PASSWORD = "wrongpassword";
    
    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver and page objects before each test
        driver = WebDriverFactory.getDefaultDriver();
        loginPage = new LoginPage(driver);
    }
    
    @AfterMethod
    public void tearDown() {
        // Clean up resources after each test
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test(description = "Verify successful login with valid credentials")
    public void testSuccessfulLogin() {
        // Navigate to the login page
        loginPage.navigateTo(TEST_URL);
        
        // Enter valid credentials and click login
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        
        // Verify that we're redirected to the secure area (URL contains "secure")
        Assert.assertTrue(driver.getCurrentUrl().contains("/secure"), 
                "User was not redirected to secure area after successful login");
    }
    
    @Test(description = "Verify error message with invalid credentials")
    public void testInvalidCredentials() {
        // Navigate to the login page
        loginPage.navigateTo(TEST_URL);
        
        // Enter invalid credentials and click login
        loginPage.login(INVALID_USERNAME, INVALID_PASSWORD);
        
        // Verify that error message is displayed
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), 
                "Error message was not displayed for invalid credentials");
        
        // Verify error message content
        String errorText = loginPage.getErrorMessageText();
        Assert.assertTrue(errorText.contains("invalid"), 
                "Error message does not contain expected text: " + errorText);
    }
    
    @Test(description = "Verify error with valid username but invalid password")
    public void testValidUsernameInvalidPassword() {
        // Navigate to the login page
        loginPage.navigateTo(TEST_URL);
        
        // Enter valid username but invalid password
        loginPage.login(VALID_USERNAME, INVALID_PASSWORD);
        
        // Verify that error message is displayed
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), 
                "Error message was not displayed for invalid password");
    }
}