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
 * Test class for CSS Selector locators on Open Library website
 */
public class CssSelectorTests {
    private WebDriver driver;
    private CssSelectorLocators cssLocators;
    
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://openlibrary.org/");
        cssLocators = new CssSelectorLocators(driver);
    }
    
    @Test(description = "Exercise 2: Find the Search button using CSS Selector")
    public void testSearchButton() {
        try {
            WebElement searchButton = driver.findElement(By.cssSelector("input[aria-label='Search submit']"));
            Assert.assertTrue(searchButton.isDisplayed(), 
                             "Search button not found using CSS selector");
            System.out.println("PASS: Successfully found Search button using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find Search button with CSS selector: " + e.getMessage());
        }
    }


    
    private WebElement searchButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test(description = "Exercise 9: Find the search box inside search form using CSS Selector")
    public void testSearchBoxInForm() {
        try {
            Assert.assertTrue(cssLocators.getSearchBoxInForm().isDisplayed(), 
                             "Search box in form not found using CSS selector");
            System.out.println("PASS: Successfully found search box in form using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find search box in form with CSS selector: " + e.getMessage());
        }
    }
    
    @Test(description = "Exercise 14: Find page number 2 link in pagination using CSS Selector")
    public void testPageTwoLink() {
        try {
            // First perform a search to get to a page with pagination
            cssLocators.getSearchBoxInForm().sendKeys("java");
            cssLocators.getSearchButton().click();
            
            // Now test the page 2 link
            Assert.assertTrue(cssLocators.getPageTwoLink().isDisplayed(), 
                             "Page 2 link not found using CSS selector");
            System.out.println("PASS: Successfully found Page 2 link using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find Page 2 link with CSS selector: " + e.getMessage());
        }
    }
    
    @Test(description = "Exercise 19: Find Terms of Service link in footer using CSS Selector")
    public void testTermsOfServiceLink() {
        try {
            Assert.assertTrue(cssLocators.getTermsOfServiceLink().isDisplayed(), 
                             "Terms of Service link not found using CSS selector");
            System.out.println("PASS: Successfully found Terms of Service link using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find Terms of Service link with CSS selector: " + e.getMessage());
        }
    }
    
    @Test(description = "Exercise 23: Find Log In button in header using CSS Selector")
    public void testLogInButton() {
        try {
            Assert.assertTrue(cssLocators.getLogInButton().isDisplayed(), 
                             "Sign In button not found using CSS selector");
            System.out.println("PASS: Successfully found Log In button using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find Log In button with CSS selector: " + e.getMessage());
        }
    }
    
    @Test(description = "Exercise 29: Find Borrow button on book detail page using CSS Selector")
    public void testBorrowButton() {
        try {
            // Navigate to a book details page first (this would need to be adjusted for actual site)
            driver.get("https://openlibrary.org/works/OL45804W/Fantastic_Mr_Fox");
            
            Assert.assertTrue(cssLocators.getBorrowButton().isDisplayed(), 
                             "Borrow button not found using CSS selector");
            System.out.println("PASS: Successfully found Borrow button using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find Borrow button with CSS selector: " + e.getMessage());
        }
    }
    
    @Test(description = "Exercise 36: Find the language browse links on the Languages page using CSS Selector")
    public void testBrowseByLanguageLinks() {
    try {
        driver.get("https://openlibrary.org/languages");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='contentHead'] h1")));

        List<WebElement> languageLinks = driver.findElements(By.cssSelector("div[id='contentHead'] h1"));

        Assert.assertTrue(languageLinks.size() > 0,
                "No language links found on the Languages page using CSS selector");

        System.out.println("PASS: Successfully found " + languageLinks.size() + " language links using CSS Selector");
    } catch (Exception e) {
        Assert.fail("Failed to find language links on the Languages page with CSS selector: " + e.getMessage());
    }
}

    
    @Test(description = "Exercise 40: Find Search Books header using CSS Selector")
    public void testSearchBooksHeader() {
        try {
            // First perform a search to get to results page
            cssLocators.getSearchBoxInForm().sendKeys("fiction");
            cssLocators.getSearchButton().click();
            
            Assert.assertTrue(cssLocators.getSearchBooksHeader().isDisplayed(), 
                             "Search Results header not found using CSS selector");
            System.out.println("PASS: Successfully found Search Results header using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find Search Results header with CSS selector: " + e.getMessage());
        }
    }
    
    @Test(description = "Exercise 44: Find the Featured Books for Trending Books carousel right arrow button using CSS Selector") 
    public void testTrendingCarouselRightArrowButton() {
    	
        try {
            WebElement rightArrowButton = driver.findElement(By.cssSelector("body > div:nth-child(9) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-   	    child(1) > button:nth-child(3)"));

	   Assert.assertTrue(rightArrowButton.isDisplayed(),
                             "Trending Books carousel right arrow button not found using CSS selector");

            System.out.println("PASS: Successfully found Trending Books carousel right arrow button using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find Trending Books carousel right arrow button with CSS selector: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 46: Find the first book cover in the search results using CSS Selector")
    public void testFirstBookCover() {
    	try {

        // Go to search results page
        driver.get("https://openlibrary.org/search?q=harry+potter");

        // Wait for the presence of at least one book cover image
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".searchResultItem .bookcover img")));

        // Get list of all book covers
        List<WebElement> covers = driver.findElements(By.cssSelector(".searchResultItem .bookcover img"));

        // Check list size
        Assert.assertTrue(covers.size() > 0, "No book covers were found.");

        WebElement firstCover = covers.get(0);

        // Check if first cover is displayed
        Assert.assertTrue(firstCover.isDisplayed(), "First book cover is not displayed.");

        System.out.println("PASS: First book cover found and displayed.");

    } catch (Exception e) {
        Assert.fail("FAILED: Could not find first book cover. Reason: " + e.getMessage());
    }
}
   @Test(description = "Exercise 46.5: Find the second book cover in the search results using CSS Selector")
   public void testSecondBookCover() {
    try {
        // Go to search results page
        driver.get("https://openlibrary.org/search?q=hunger+games&mode=everything");

        // Wait until at least two book covers are present in the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> bookCovers = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".searchResultItem .bookcover img"))
        );

        // Ensure that at least two book covers are found
        if (bookCovers.size() < 2) {
            Assert.fail("Second book cover not found, only found " + bookCovers.size() + " book covers.");
        }

        // Get the second book cover image element
        WebElement secondCover = bookCovers.get(1); // Index 1 = second item in list

        // Assert it's displayed
        Assert.assertTrue(secondCover.isDisplayed(), "Second book cover is not displayed.");

        System.out.println("PASS: Second book cover found and displayed.");
    } catch (Exception e) {
        Assert.fail("FAILED: Could not find second book cover. Reason: " + e.getMessage());
    }
}

    @Test(description = "Exercise 54: Find the Sign Up button at the top-right corner using CSS Selector")
    public void testSignUpButton() {
        try {
            WebElement signUpButton = driver.findElement(By.cssSelector(".btn.primary"));
            Assert.assertTrue(signUpButton.isDisplayed(), 
                             "Sign Up button not found using CSS selector");
            System.out.println("PASS: Successfully found Sign Up button using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find Sign Up button with CSS selector: " + e.getMessage());
        }
    }


    @Test(description = "Exercise 64: Find the Art Books from Browse by Subject section using CSS Selector") 
    public void testBooksSection() {
        try {
            WebElement booksSection = driver.findElement(By.cssSelector("img[alt='browse Art books']"));
            Assert.assertTrue(booksSection.isDisplayed(), 
                             "Art Books button not found using CSS selector");
            System.out.println("PASS: Successfully found Art books button using CSS Selector");
        } catch (Exception e) {
            Assert.fail("Failed to find Sign Up button with CSS selector: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 71: Find the second book in the Best Books section using CSS Selector") 
    public void testSecondBestBook() {
        try {
              WebElement secondBestBook = driver.findElement(By.cssSelector(".book.carousel__item.slick-slide:nth-child(2) img"));
              Assert.assertTrue(secondBestBook.isDisplayed(), 
                         "Second Best Book not found using CSS selector");
              System.out.println("PASS: Successfully found Second Best Book using CSS Selector");
    }       catch (Exception e) {
              Assert.fail("Failed to find Second Best Book with CSS selector: " + e.getMessage());
    }
}
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}