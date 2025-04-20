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
   
   // Exercise 54: Find the "Sign Up" button at the top-right corner using CSS Selector
   public WebElement getSignUpButton() {
        return driver.findElement(By.cssSelector(".btn.primary"));


   }

   // Exercise 64: Find the "Art Books" from Browse by Subject section using CSS Selector 
   public WebElement getBooksSection() {
        return driver.findElement(By.cssSelector("img[alt='browse Art books']"));


   }

   // Exercise 71: Find the second book in the "Books We Love" section using CSS Selector
   public WebElement getSecondBestBook() {
        return driver.findElement(By.cssSelector(".carousel__item:nth-child(2) .book-cover img"));

   }



   // Exercise 79: Find the "Blog" section using CSS Selector
   public WebElement getBlogSection() {
        return driver.findElement(By.cssSelector("body > footer:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)"));


   }

   // Exercise 81: Find the "Search by barcode" button icon in the form using CSS Selector
   public WebElement getSearchByBarcodeButton() {
        return driver.findElement(By.cssSelector("#barcode_scanner_link"));


   }

   // Exercise 84: Find the "Follow Us on Twitter" button using CSS Selector
   public WebElement getFollowUsOnTwitter() {
        return driver.findElement(By.cssSelector("img[src='/static/images/tweet.svg']"));


   }

   // Exercise 86: Find the "Next Page" button in the pagination using CSS Selector
   public WebElement getNextPageButton() {
        return driver.findElement(By.cssSelector("body > div:nth-child(9) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > a:nth-child(2)"));



   }

  // Exercise 91: Find the first book image in the "Trending Books" carousel using CSS Selector
  public WebElement getFirstTrendingBooks() {
    // Look for book covers that are currently visible
    return driver.findElement(By.cssSelector(".book-cover img[src*='covers.openlibrary.org']"));


  }

   // Exercise 96: Find the "Writing Bots" button on a book detail page using CSS Selector
   public WebElement getWritingBotsButton() {
        return driver.findElement(By.cssSelector("a[title='Write a bot']"));



  }

   // Exercise 99:  Find the "Browse" button using CSS Selector
   public WebElement getBrowseButton() {
        return driver.findElement(By.cssSelector("ul[class='navigation-component'] summary:nth-child(1)"));


}
}
