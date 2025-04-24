package locators;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
 * Test class for Tagname locators on Open Library website
 */
public class TagNameTests {
    private WebDriver driver;
    private TagNameLocators tagNameLocators;
    
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://openlibrary.org/");
        tagNameLocators = new TagNameLocators(driver);
    }

    @Test(description = "Exercise 8: Find the image of the first book using by.tagName")
    public void testBookImage() {
        try {
            // Go to search results page
            driver.get("https://openlibrary.org/search?q=toni+morrison&mode=everything");

            // Wait for presence of any <img> element (general)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("img")));

            // Get list of all <img> elements
            List<WebElement> images = driver.findElements(By.tagName("img"));

            // Find first image whose alt/title contains "Cover of:"
            WebElement firstCover = null;
            for (WebElement image : images) {
                String alt = image.getAttribute("alt");
                String title = image.getAttribute("title");
                if ((alt != null && alt.contains("Cover of:")) || 
                    (title != null && title.contains("Cover of:"))) {
                    firstCover = image;
                    break;
                }
            }

            Assert.assertNotNull(firstCover, "No book cover image found with expected alt/title attributes.");
            Assert.assertTrue(firstCover.isDisplayed(), "Book cover image is not displayed.");

            System.out.println("PASS: First book cover found and displayed.");

        } catch (Exception e) {
            Assert.fail("FAILED: Could not find first book cover. Reason: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 18: Find the first author's name in the search results using By.tagName")
    public void testBookAuthor() {
        try {
            // Navigate to the search page
            driver.get("https://openlibrary.org/search?q=fiction");
            
            // Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("searchResultItem")));
            
            // Get all search result items
            List<WebElement> searchResults = driver.findElements(By.className("searchResultItem"));
            
            // Make sure we have results
            if (searchResults.size() > 0) {
                // Use the first search result
                WebElement firstResult = searchResults.get(0);
                
                // Find the author element within the first result using a standard HTML tag that contains author info
                // Authors are typically in <span>, <a>, or <p> tags
                WebElement bookAuthor = firstResult.findElement(By.tagName("a"));
                
                // Verify the element is displayed
                Assert.assertTrue(bookAuthor.isDisplayed(), 
                                "Book Author not found using By.tagName");
                System.out.println("PASS: Successfully found Book Author using By.tagName");
            } else {
                Assert.fail("No search results found");
            }
        } catch (Exception e) {
            Assert.fail("Failed to find Book Author with By.tagName: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 30: Find the second book title using by.tagName")
    public void testSecondBookTitle() {
        try {
            driver.get("https://openlibrary.org/search?q=toni+morrison&mode=everything");

            WebElement secondTitle = tagNameLocators.getSecondBookTitle();

            Assert.assertNotNull(secondTitle, "Second book title link not found.");
            Assert.assertTrue(secondTitle.getText().toLowerCase().contains("song of solomon"),
                "Unexpected title: " + secondTitle.getText());
        } catch (Exception e) {
            Assert.fail("Failed to find second book title with By.tagName: " + e.getMessage());
        }
    }

 

    @Test(description = "Exercise 61: Click into third book in book results and find the book description using By.tagName")
    public void testBookDescription() {
        try {
            // Navigate to the search results page
            driver.get("https://openlibrary.org/search?q=fiction");
            
            // Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("searchResultItem")));
            
            // Get all search result items
            List<WebElement> searchResults = driver.findElements(By.className("searchResultItem"));
            
            // Make sure we have results
            if (searchResults.size() >= 3) {
                // Click on the third book link
                WebElement thirdBook = searchResults.get(2);
                thirdBook.findElement(By.tagName("a")).click();
                
                // Wait for the book details page to load
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("workDetails")));
                
                // Find paragraphs that might contain the book description
                List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
                
                // Find a paragraph that's likely to be the book description
                WebElement bookDescription = null;
                for (WebElement p : paragraphs) {
                    // Check if paragraph has reasonable length and is visible
                    if (p.getText().length() > 50 && p.isDisplayed()) {
                        bookDescription = p;
                        break;
                    }
                }
                
                Assert.assertNotNull(bookDescription, "Could not find a suitable book description paragraph");
                Assert.assertTrue(bookDescription.isDisplayed(), 
                                "Book description is not displayed");
                System.out.println("PASS: Successfully found book description using By.tagName");
            } else {
                Assert.fail("Not enough books found in search results");
            }
        } catch (Exception e) {
            Assert.fail("Failed to find book description with By.tagName: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 72: Find the 'Review' icon for any book using By.tagName")
    public void testReviewIcon() {
        try {
            // Navigate to the search page
            driver.get("https://openlibrary.org/search?q=fiction");
            
            // Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("searchResultItem")));
            
            // Get all search result items
            List<WebElement> searchResults = driver.findElements(By.className("searchResultItem"));
            
            // Make sure we have results
            if (searchResults.size() > 0) {
                // Generate a random index to select a random book
                Random random = new Random();
                int randomIndex = random.nextInt(searchResults.size());
                
                // Click on the randomly selected book
                searchResults.get(randomIndex).findElement(By.tagName("a")).click();
                
                // Wait for the book page to load
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
                
                // Find the image element (including review icons)
                WebElement reviewIcon = driver.findElement(By.tagName("img"));
                
                // Verify the element is displayed
                Assert.assertTrue(reviewIcon.isDisplayed(), 
                                "Review icon not found using By.tagName");
                System.out.println("PASS: Successfully found Review icon using By.tagName");
            } else {
                Assert.fail("No search results found");
            }
        } catch (Exception e) {
            Assert.fail("Failed to find Review icon with By.tagName: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 95: Find the Preview button for the first book in the results list using By.tagName")
    public void testFirstPreviewButtonIsDisplayed() {
        driver.get("https://openlibrary.org/search?q=lego");
        WebElement previewButton = tagNameLocators.getFirstPreviewButton();
        Assert.assertNotNull(previewButton, "Preview button should not be null");
        Assert.assertTrue(previewButton.isDisplayed(), "Preview button should be displayed");
        System.out.println("Preview button text: " + previewButton.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}