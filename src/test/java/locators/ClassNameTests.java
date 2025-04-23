package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for Class Name locators on Demo QA website
 */
public class ClassNameTests {
    private WebDriver driver;
    private ClassNameLocators classNameLocators;
    
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        classNameLocators = new ClassNameLocators(driver);
    }
    
    @Test(description = "Exercise 5: Find the Body Height Container using By.className")
    public void testBodyHeightContainer() {
        try {
            Assert.assertTrue(classNameLocators.getBodyHeightContainer().isDisplayed(), 
                             "Body Height Container not found using By.className");
            System.out.println("PASS: Successfully found Body Height Container using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Body Height Container using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise 13: Find the container element using By.className")
    public void testContainer() {
        try {
            Assert.assertTrue(classNameLocators.getContainer().isDisplayed(), 
                             "Container not found using By.className");
            System.out.println("PASS: Successfully found Container using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Container using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise 20: Find the header-text element using By.className")
    public void testHeaderText() {
        try {
            Assert.assertTrue(classNameLocators.getHeaderText().isDisplayed(), 
                             "Header Text not found using By.className");
            System.out.println("PASS: Successfully found Header Text using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Header Text using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise 28: Find the main content using By.className")
    public void testMainContainer() {
        try {
            Assert.assertTrue(classNameLocators.getMainContainer().isDisplayed(), 
                             "Main Container not found using By.className");
            System.out.println("PASS: Successfully found Main Container using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Main Container using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise 32: Find the row element using By.className")
    public void testRow() {
        try {
            Assert.assertTrue(classNameLocators.getRow().isDisplayed(), 
                             "Row not found using By.className");
            System.out.println("PASS: Successfully found Row using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Row using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise  42: Find the accordion element using By.className")
    public void testAccordion() {
        try {
            Assert.assertTrue(classNameLocators.getAccordion().isDisplayed(), 
                             "Accordion not found using By.className");
            System.out.println("PASS: Successfully found Accordion using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Accordion using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise 45: Find the left-pannel element using By.className")
    public void testLeftPanel() {
        try {
            Assert.assertTrue(classNameLocators.getLeftPanel().isDisplayed(), 
                             "Left Panel not found using By.className");
            System.out.println("PASS: Successfully found Left Panel using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Left Panel using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise 53: Find the element-group using By.className")
    public void testElementGroup() {
        try {
            Assert.assertTrue(classNameLocators.getElementGroup().isDisplayed(), 
                             "Element Group not found using By.className");
            System.out.println("PASS: Successfully found Element Group using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Element Group using By.className:" + e.getMessage());
        }
    }


    @Test(description = "Exercise 57: Find the navbar element using By.className")
    public void testNavbar() {
        try {
            Assert.assertTrue(classNameLocators.getNavbar().isDisplayed(), 
                             "Navbar not found using By.className");
            System.out.println("PASS: Successfully found Navbar using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Navbar using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise 68: Find the header-wrapper using By.className")
    public void testHeaderWrapper() {
        try {
            Assert.assertTrue(classNameLocators.getHeaderWrapper().isDisplayed(), 
                             "Header Wrapper not found using By.className");
            System.out.println("PASS: Successfully found Header Wrapper using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Header Wrapper using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise 83: Find the PR1 element using By.className")
    public void testPR1() {
        try {
            Assert.assertTrue(classNameLocators.getPR1().isDisplayed(), 
                             "PR1 element not found using By.className");
            System.out.println("PASS: Successfully found PR1 element using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find PR1 element using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise 89: Find the group-header element using By.className")
    public void testGroupHeader() {
        try {
            Assert.assertTrue(classNameLocators.getGroupHeader().isDisplayed(), 
                             "Group Header not found using By.className");
            System.out.println("PASS: Successfully found Group Header using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Group Header using By.className:" + e.getMessage());
        }
    }

    @Test(description = "Exercise  94: Find the col-md-3 element using By.className")
    public void testColMd3() {
        try {
            Assert.assertTrue(classNameLocators.getColMd3().isDisplayed(), 
                             "Col-md-3 not found using By.className");
            System.out.println("PASS: Successfully found Col-md-3 using By.className");
        } catch (Exception e) {
            Assert.fail("Failed to find Col-md-3 using By.className:" + e.getMessage());
        }
    }




 @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}