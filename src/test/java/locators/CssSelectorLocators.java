package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelectorLocators {
    private WebDriver driver;
    
    public CssSelectorLocators(WebDriver driver) {
        this.driver = driver;
    }
    
    // Exercise 2: Find the "Search" button
    public WebElement getSearchButton() {
        return driver.findElement(By.cssSelector("input[aria-label='Search submit']"));
    }
    
    // Exercise 9: Find the search box inside the search form
    public WebElement getSearchBoxInForm() {
        return driver.findElement(By.cssSelector("form input[type='text']"));
    }
    
    // Exercise 14: Find the page number 2 link in pagination
    public WebElement getPageTwoLink() {
        return driver.findElement(By.cssSelector("body > div:nth-child(9) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) >    	a:nth-child(2)"));
    }
    
    // Exercise 19: Find the link to "Terms of Service" in the footer
    public WebElement getTermsOfServiceLink() {
        return driver.findElement(By.cssSelector("footer a[href*='terms']"));
    }
    
    // Exercise 23: Find the "Log In" button in the header
    public WebElement getLogInButton() {
        return driver.findElement(By.cssSelector("a[class='btn']"));
    }
    
    // Exercise 29: Find the "Borrow" button on a book's detail page
    public WebElement getBorrowButton() {
        return driver.findElement(By.cssSelector("div[id='read-options'] a[title='Borrow ebook from Internet Archive']"));
    }
    
    // Exercise 36: Find the language browse links on the Languages page using CSS Selector
    public List<WebElement> getBrowseByLanguageLinks() {
        return driver.findElements(By.cssSelector("div[id='contentHead'] h1"));
    }
    
    // Exercise 40: Find the "Search Books" header
    public WebElement getSearchBooksHeader() {
        return driver.findElement(By.cssSelector("div[id='contentHead'] h1"));
    }

    // Exercise 44: Find the Featured Books for "Trending Books carousel right arrow" button using CSS Selector
    public WebElement getRightArrowButton () {
	return driver.findElement(By.cssSelector("body > div:nth-child(9) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > button:nth-child(3)"));

    }
    // Exercise 46s: Find the first (any) book cover in the search results using CSS Selector
   public WebElement getBookCoverByIndex(int index) {
    List<WebElement> covers = driver.findElements(By.cssSelector(".searchResultItem .bookcover img"));
    if (covers.size() > index) {
        return covers.get(index);
    } else {
        System.out.println("WARNING: Only found " + covers.size() + " book cover(s). Index " + index + " is out of range.");
        return null;
    }
}
}
