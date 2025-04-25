package locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Test class for Partial Link locators on Open Library website
 */
public class PartialLinkTextTests {
    private WebDriver driver;
    private PartialLinkTextLocators partialLinkTextLocators;
    
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://openlibrary.org/");
        partialLinkTextLocators = new PartialLinkTextLocators(driver);
    }
    
    @Test(description = "Exercise 6: Find the Volunteer link in the footer using By.partialLinkText")
    public void testVolunteerLink() {
        try {
            WebElement volunteerLink = partialLinkTextLocators.getVolunteerLink();
            Assert.assertTrue(volunteerLink.isDisplayed(), 
                             "Volunteer Link not found using Partial Link Text");
            System.out.println("PASS: Successfully found Volunteer Link using Partial Link Text");

            volunteerLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Volunteer Link with Partial Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 17: Find the Classics Books link on the Classics Books Carousel section using By.partialLinkText")
    public void testClassicBooksLink() {
        try {
            WebElement classicBooksLink = partialLinkTextLocators.getClassicBooksLink();
            Assert.assertTrue(classicBooksLink.isDisplayed(), 
                             "Classic Books Link not found using Partial Link Text");
            System.out.println("PASS: Successfully found Classic Books Link using Partial Link Text");

            classicBooksLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Classic Books Link with Partial Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 25: Find the LogIn link using By.partialLinkText")
    public void testLogInLink() {
        try {
            WebElement logInLink = partialLinkTextLocators.getLogInLink();
            Assert.assertTrue(logInLink.isDisplayed(), 
                             "Log In Link not found using Partial Link Text");
            System.out.println("PASS: Successfully found Log In Link using Partial Link Text");

            logInLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Log In Link with Partial Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 35: Find the Subjects link using By.partialLinkText")
    public void testSubjectsLink() {
        try {
            WebElement subjectsLink = partialLinkTextLocators.getSubjectsLink();
            Assert.assertTrue(subjectsLink.isDisplayed(), 
                             "Subjects Link not found using Partial Link Text");
            System.out.println("PASS: Successfully found Subjects Link using Partial Link Text");

            subjectsLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Subjects Link with Partial Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 47: Find the Authors link in the search results using By.partialLinkText")
    public void testAuthorsLink() {
        try {
            WebElement authorsLink = partialLinkTextLocators.getAuthorsLink();
            Assert.assertTrue(authorsLink.isDisplayed(), 
                             "Authors Link not found using Partial Link Text");
            System.out.println("PASS: Successfully found Authors Link using Partial Link Text");

            authorsLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Authors Link with Partial Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 56: Find the Return to Top category in the navigation menu using By.partialLinkText")
    public void testReturnToTopLink() {
        try {
            WebElement returnToTopLink = partialLinkTextLocators.getReturnToTopLink();
            Assert.assertTrue(returnToTopLink.isDisplayed(), 
                             "Return To Top Link not found using Partial Link Text");
            System.out.println("PASS: Successfully found Return To Top Link using Partial Link Text");

            returnToTopLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Return To Top Link with Partial Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 60: Find the Italiano link in a book detail page using By.partialLinkText")
    public void testItalianoLink() {
        try {
            WebElement italianoLink = partialLinkTextLocators.getItalianoLink();
            Assert.assertTrue(italianoLink.isDisplayed(), 
                             "Italiano Link not found using Partial Link Text");
            System.out.println("PASS: Successfully found Italiano Link using Partial Link Text");

            italianoLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Italiano Link with Partial Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 66: Find the Add a Book link using By.partialLinkText")
    public void testAddABookLink() {
        try {
            WebElement addABookLink = partialLinkTextLocators.getAddABookLink();
            Assert.assertTrue(addABookLink.isDisplayed(), 
                             "Add A Book link not found using Partial Link Text");
            System.out.println("PASS: Successfully found Add A Book link using Partial Link Text");

            addABookLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Add A Book link with Partial Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 76: Find the Book Preview button on a book's detail page using By.partialLinkText")
    public void testBookPreviewButton() {
        try {
            // Navigate to the search results page
            driver.get("https://openlibrary.org/search?q=fiction");
            
            // Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("searchResultItem")));
            
            // Get all search result items
            List<WebElement> searchResults = driver.findElements(By.className("searchResultItem"));
            
            // Make sure we have results
            if (searchResults.size() > 0) {
                // Find the Preview link in the first search result
                WebElement bookPreviewButton = partialLinkTextLocators.getBookPreviewButton();
                
                Assert.assertTrue(bookPreviewButton.isDisplayed(), 
                                 "Book Preview Button not found using Partial Link Text");
                System.out.println("PASS: Successfully found Book Preview Button using Partial Link Text");
                
                bookPreviewButton.click();
            } else {
                Assert.fail("No search results found");
            }
        } catch (Exception e) {
            Assert.fail("Failed to find Book Preview Button with Partial Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 93: Find the Terms of Service button in the footer using By.partialLinkText")
    public void testTermsOfServiceLink() {
        try {
            WebElement termsOfServiceLink = partialLinkTextLocators.getTermsOfServiceLink();
            Assert.assertTrue(termsOfServiceLink.isDisplayed(), 
                             "Terms Of Service Link not found using Partial Link Text");
            System.out.println("PASS: Successfully found Terms Of Service Link using Partial Link Text");

            termsOfServiceLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Terms Of Service Link with Partial Link Text: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}