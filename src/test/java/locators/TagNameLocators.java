package locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagNameLocators {
    private WebDriver driver;
    
    public TagNameLocators(WebDriver driver) {
        this.driver = driver;
    }
    
    // Exercise 8: Find the image of the first book using By.tagName
    public WebElement getBookImage() {
        return driver.findElement(By.tagName(".searchResultItem .bookcover img"));
    }
    
    // Exercise 18: Find the first author's name in the search results using By.tagName
    public WebElement getBookAuthor() {
        return driver.findElement(By.tagName("bookauthor"));
    }
    
    // Exercise 30: Find the second book title on the page using By.tagName
    public WebElement getSecondBookTitle() {
    // Find all anchor tags
    List<WebElement> links = driver.findElements(By.tagName("a"));

    // Loop to find the second one with class "results" — those are the book title links
    int count = 0;
    for (WebElement link : links) {
        if (link.getAttribute("class") != null && link.getAttribute("class").contains("results")) {
            count++;
            if (count == 2) {
                return link;
            }
        }
    }

    return null; // Return null if not found

}
    
    // Exercise 41:  Find the first book's author in the Recently Returned carousel using By.tagName
    public WebElement getFirstRecentlyReturnedAuthor() {
        // Wait for carousel to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("carousel-container")));
        
        // Find the Recently Returned section
        WebElement carousel = driver.findElement(By.id("recent-returns"));
        // Get first book cover
        WebElement firstBook = carousel.findElement(By.tagName("a"));
        // Find the author element
        return firstBook.findElement(By.tagName("span"));
    }
    // Exercise 51: Find the first book title in the "Books We Love" section using By.tagName
    public WebElement getFirstBooksWeLoveTitle() {
        // Wait for carousel to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("books_carousel")));
        
        // Find the Books We Love section
        WebElement carousel = driver.findElement(By.id("books_carousel"));
        // Get first book and its image
        return carousel.findElement(By.tagName("img"));
    }

   // Exercise 61: Find the book description using By.tagName
   public WebElement getBookDescription() {
        return driver.findElement(By.tagName("p"));
}
    
    // Exercise 72: Find the "Review" icon for any book using By.tagName
    public WebElement getReviewIcon() {
        return driver.findElement(By.tagName("img"));
    }
    
    // Exercise 95: Find the "Preview" button for the first book in the results list using By.tagName
    public WebElement getFirstPreviewButton() {
    WebElement firstResult = driver.findElement(By.className("searchResultItem"));
    List<WebElement> links = firstResult.findElements(By.tagName("a"));

    for (WebElement link : links) {
        if (link.getText().equalsIgnoreCase("Preview")) {
            return link;
        }
    }
    return null; // Preview button not found
}
}