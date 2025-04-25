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
 * Test class for Link locators on Open Library website
 */
public class LinkTextTests {
    private WebDriver driver;
    private LinkTextLocators linkTextLocators;
    
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://openlibrary.org/");
        linkTextLocators = new LinkTextLocators(driver);
    }
    
    @Test(description = "Exercise 3: Find the link to Advanced Search using By.linkText")
    public void testAdvancedSearchLink() {
        try {
            WebElement advancedSearchLink = linkTextLocators.getAdvancedSearchLink();
            Assert.assertTrue(advancedSearchLink.isDisplayed(), 
                             "Advanced Search Link not found using Link Text");
            System.out.println("PASS: Successfully found Advanced Search Link using Link Text");

            advancedSearchLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Advanced Search Link using Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 10: Find the Contact Us link in the footer using By.linkText")
    public void testContactUsLink() {
        try {

            // Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Contact Us")));  

            WebElement contactUsLink = linkTextLocators.getContactUsLink();
            Assert.assertTrue(contactUsLink.isDisplayed(), 
                             "Contact Us Link not found using Link Text");
            System.out.println("PASS: Successfully found Contact Us Link using Link Text");
           
            contactUsLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Contact Us Link with Link Text: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 22: Find the link to Donate using Link Text")
    public void testDonateLink() {
        try {
            WebElement donateLink = linkTextLocators.getDonateLink();
            Assert.assertTrue(donateLink.isDisplayed(), 
                             "Donate Link not found using Text Link");
            System.out.println("PASS: Successfully found Donate Link using Text Link");

            donateLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Donate Link with Text Link: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 37: Find the link to Help Center using By.linkText")
    public void testHelpCenterLink() {
        try {
            WebElement helpCenterLink = linkTextLocators.getHelpCenterLink();
            Assert.assertTrue(helpCenterLink.isDisplayed(), 
                             "Help Center Link not found using Text Link");
            System.out.println("PASS: Successfully found Help Center Link using Text Link");

            helpCenterLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Help Center Link with Text Link: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 50: Find the Kids link under book categories using By.linkText")
    public void testKidsLink() {
        try {
            WebElement kidsLink = linkTextLocators.getKidsLink();
            Assert.assertTrue(kidsLink.isDisplayed(), 
                             "Kids Link not found using Text Link");
            System.out.println("PASS: Successfully found Kids Link using Text Link");

            kidsLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Kids Link with Text Link: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 55: Find the Preview link under each book in the search results using By.linkText")
    public void testPreviewLink() {
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
            WebElement previewLink = linkTextLocators.getPreviewLink();
            
            Assert.assertTrue(previewLink.isDisplayed(), 
                           "Preview Link not found using Text Link");
            System.out.println("PASS: Successfully found Preview Link using Text Link");
            
            previewLink.click();
        } else {
            Assert.fail("No search results found");
        }
    } catch (Exception e) {
        Assert.fail("Failed to find Preview Link with Text Link: " + e.getMessage());
    }
}



    @Test(description = "Exercise 62: Find the Vision link in the footer using By.linkText")
    public void testVisionLink() {
        try {
            WebElement visionLink = linkTextLocators.getVisionLink();
            Assert.assertTrue(visionLink.isDisplayed(), 
                             "Vision Link not found using Text Link");
            System.out.println("PASS: Successfully found Vision Link using Text Link");

            visionLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Vision Link with Text Link: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 77: Find the My Account link in the header using By.linkText")
    public void testMyAccountLink() {
        try {
            WebElement myAccountLink = linkTextLocators.getMyAccountLink();
            Assert.assertTrue(myAccountLink.isDisplayed(), 
                             "My Account Link not found using Text Link");
            System.out.println("PASS: Successfully found My Account Link using Text Link");

            myAccountLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find My Account Link with Text Link: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 87: Find the Español link using By.linkText")
    public void testEspanolLink() {
        try {
            WebElement espanolLink = linkTextLocators.getEspanolLink();
            Assert.assertTrue(espanolLink.isDisplayed(), 
                             "Español Link not found using Text Link");
            System.out.println("PASS: Successfully found Español Link using Text Link");

            espanolLink.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Español Link with Text Link: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}