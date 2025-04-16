package ctrl.alt.del.g1thub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object for a sample login page.
 * This class represents the login page of the application being tested.
 */
public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login");
    private By errorMessage = By.className("error-message");
    
    /**
     * Constructor for the LoginPage
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    /**
     * Navigate to the login page
     * @param url The URL of the login page
     * @return LoginPage instance for method chaining
     */
    public LoginPage navigateTo(String url) {
        driver.get(url);
        return this;
    }
    
    /**
     * Enter username in the username field
     * @param username Username to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage enterUsername(String username) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        element.clear();
        element.sendKeys(username);
        return this;
    }
    
    /**
     * Enter password in the password field
     * @param password Password to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        element.clear();
        element.sendKeys(password);
        return this;
    }
    
    /**
     * Click on the login button
     * @return LoginPage instance for method chaining
     */
    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return this;
    }
    
    /**
     * Perform login operation with provided credentials
     * @param username Username to enter
     * @param password Password to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return this;
    }
    
    /**
     * Check if error message is displayed
     * @return true if error message is displayed, false otherwise
     */
    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get the text of the error message
     * @return Error message text
     */
    public String getErrorMessageText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}