package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for ID locators on the Open Library website
 */
public class IDTests {
    private WebDriver driver;
    private IDLocators idLocators;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        idLocators = new IDLocators(driver);
    }

    @Test(description = "Exercise 7: Click on Accordian Open using ID")
    public void testAccordianOpen() {
        try {
            // Navigate directly to Accordian page
            driver.get("https://demoqa.com/accordian");

            WebElement accordianOpen = idLocators.getAccordianOpen();
            Assert.assertTrue(accordianOpen.isDisplayed(),
                    "Accordian Open not found using ID");
            System.out.println("PASS: Successfully found Accordian Open using ID");
        } catch (Exception e) {
            Assert.fail("Failed to find Accordian Open with ID: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 98: Find the 'Submit' button on Registration Form update in Web Tables using ID")
    public void testRegistrationSubmitButton() {
        try {
            // Navigate to Web Tables page
            driver.get("https://demoqa.com/webtables");

            Thread.sleep(2000);

            // Click edit button for the first row
            WebElement editButton = driver.findElement(By.cssSelector("span[id='edit-record-1'] svg"));
            editButton.click();

            Thread.sleep(1000);

            // Fill out the form - updating First Name for example
            WebElement firstNameField = driver.findElement(By.id("firstName"));
            firstNameField.clear();
            firstNameField.sendKeys("UpdatedName");

            // Submit the form
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            Thread.sleep(2000);

            // Confirm the table row has updated value
            WebElement updatedCell = driver.findElement(By.cssSelector(".rt-tr-group div[role='gridcell']:nth-child(1)"));
            String updatedText = updatedCell.getText();

            Assert.assertEquals(updatedText, "UpdatedName", "Name not updated correctly in table.");
            System.out.println("Test Passed: Info updated correctly");

        } catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
