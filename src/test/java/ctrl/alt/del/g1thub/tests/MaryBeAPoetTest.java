package ctrl.alt.del.g1thub.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class MaryBeAPoetTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {
        System.out.println("Setting up WebDriver for all tests");
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @BeforeMethod
    public void navigateToHomePage() {
        System.out.println("Navigating to website homepage");
        driver.get("https://www.marybeapoet.com/");
    }
    
    @Test(priority = 1)
    public void testPageTitle() {
        String expectedTitle = "Mary Gray Black Poet";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), 
                "Expected title to contain '" + expectedTitle + "' but was '" + actualTitle + "'");
        System.out.println("Title test passed: " + actualTitle);
    }
    
    @Test(priority = 2)
    public void testNavigationMenu() {
        WebElement navMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("nav")));
        Assert.assertTrue(navMenu.isDisplayed(), "Navigation menu should be displayed");
        
        List<WebElement> navLinks = navMenu.findElements(By.tagName("a"));
        System.out.println("Found " + navLinks.size() + " navigation links");
        Assert.assertTrue(navLinks.size() > 0, "Navigation should contain links");
    }
    
    @Test(priority = 3)
    public void testContactPage() {
        // Find and click contact link
        WebElement contactLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact")));
        Assert.assertTrue(contactLink.isDisplayed(), "Contact link should be visible");
        
        contactLink.click();
        
        // Verify navigation to contact page
        wait.until(ExpectedConditions.urlContains("contact"));
        System.out.println("Successfully navigated to Contact page");
        
        // Check if contact form exists
        WebElement contactForm = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("form")));
        Assert.assertTrue(contactForm.isDisplayed(), "Contact form should be displayed");
    }
    
    @Test(priority = 4)
    public void testSocialMediaLinks() {
        // Check for social media links in the footer
        List<WebElement> socialLinks = driver.findElements(By.cssSelector(
                "footer a[href*='facebook'], footer a[href*='instagram'], footer a[href*='twitter']"));
        Assert.assertTrue(socialLinks.size() > 0, "Should find at least one social media link");
        System.out.println("Found " + socialLinks.size() + " social media links");
    }
    
    @Test(priority = 5, dependsOnMethods = {"testPageTitle", "testNavigationMenu"})
    public void testNavigationBackToHomepage() {
        // First navigate to contact page
        WebElement contactLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact")));
        contactLink.click();
        wait.until(ExpectedConditions.urlContains("contact"));
        
        // Then navigate back to homepage
        driver.navigate().back();
        
        // Verify we're back at the homepage
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://www.marybeapoet.com/") || 
                currentUrl.equals("https://www.marybeapoet.com"), 
                "Should have navigated back to homepage");
    }
    
    @AfterMethod
    public void takeScreenshotOnFailure(java.lang.reflect.Method method) {
        // This would typically include code to capture screenshots for failed tests
        System.out.println("Test method completed: " + method.getName());
    }
    
    @AfterClass
    public void tearDown() {
        System.out.println("Cleaning up - closing browser");
        if (driver != null) {
            driver.quit();
        }
    }
}