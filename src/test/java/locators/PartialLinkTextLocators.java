package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PartialLinkTextLocators {
    private WebDriver driver;
    
    public PartialLinkTextLocators(WebDriver driver) {
        this.driver = driver;
    }
    
    // Exercise 6: Find the "Volunteer" link in the footer using By.partialLinkText
    public WebElement getVolunteerLink() {
        return driver.findElement(By.partialLinkText("Volunte"));
    }
    
    // Exercise 17: Find the "Classics Books" link on the Classics Books Carousel section using By.partialLinkText
    public WebElement getClassicBooksLink() {
        return driver.findElement(By.partialLinkText("Classic Boo"));
    }
    
    // Exercise 25: Find the "LogIn" link using By.partialLinkText
    public WebElement getLogInLink() {
        return driver.findElement(By.partialLinkText("Log"));
    }
    
    // Exercise 35: Find the "Subjects" section link using By.partialLinkText
    public WebElement getSubjectsLink() {
        return driver.findElement(By.partialLinkText("Subjec"));
    }
    
    // Exercise 47: Find the "Authors" link in the footer using By.partialLinkText
    public WebElement getAuthorsLink() {
        return driver.findElement(By.partialLinkText("Autho"));
    }
    
    // Exercise 56: Find the "Return to Top" link in the footer using By.partialLinkText
    public WebElement getReturnToTopLink() {
        return driver.findElement(By.partialLinkText("Return to T"));
    }
    
    // Exercise 60: Find the "Italiano" link  using By.partialLinkText
    public WebElement getItalianoLink() {
        return driver.findElement(By.partialLinkText("Italiano (i"));
    }
    
    // Exercise 66: Find the "Add a Book" link using By.partialLinkText
    public WebElement getAddABookLink() {
        return driver.findElement(By.partialLinkText("Add a Bo"));
    }
    
    // Exercise 76: Find the "Book Preview" button on a book's detail page using By.partialLinkText
    public WebElement getBookPreviewButton() {
    // Wait for search results to load
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("searchResultItem")));
    
        return driver.findElement(By.partialLinkText("Previ"));
    }
    
    // Exercise 93: Find the "Terms of Service" link in the footer using By.partialLinkText
    public WebElement getTermsOfServiceLink() {
        return driver.findElement(By.partialLinkText("Terms of Servi"));
    }
}