package github.ctrlaltdel.selenium.openlibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenLibrarySearchTest {

    WebDriver driver;
    @Test
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Automatically sets the right driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchForTheHobbit() throws InterruptedException {
        driver.get("https://openlibrary.org");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("The Hobbit");
        searchBox.submit();

        Thread.sleep(3000); // For learning purposes; use WebDriverWait in advanced versions

        WebElement firstResult = driver.findElement(By.cssSelector(".searchResultItem .booktitle"));
        String title = firstResult.getText().toLowerCase();

        Assert.assertTrue(title.contains("hobbit"), "Expected title to contain 'hobbit'");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

@Test
public void navigateToBookDetailAfterSearch() throws InterruptedException {
    driver.get("https://openlibrary.org");

    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("The Hobbit");
    searchBox.submit();

    Thread.sleep(3000); // Again, replace with waits later

    WebElement firstResult = driver.findElement(By.cssSelector(".searchResultItem a"));
    firstResult.click();

    Thread.sleep(3000);

    WebElement titleHeading = driver.findElement(By.cssSelector("h1"));
    String bookTitle = titleHeading.getText().toLowerCase();

    Assert.assertTrue(bookTitle.contains("hobbit"), "Expected to land on a Hobbit book detail page");
}
}