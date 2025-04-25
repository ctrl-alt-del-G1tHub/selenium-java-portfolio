package locators;

import java.time.Duration;

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
 * Test class for XPath locators on DemoQA Checkbox page
 */
public class XPathTests {
    private WebDriver driver;
    private XPathLocators xpathLocators;
    
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
        xpathLocators = new XPathLocators(driver);
    }
    
    @Test(description = "Exercise 4: Find the Home checkbox item using By.xpath")
    public void testHomeCheckbox() {
        try {
            WebElement homeCheckbox = xpathLocators.getHomeCheckbox();
            Assert.assertTrue(homeCheckbox.isDisplayed(), 
                             "Home checkbox not found using XPath");
            System.out.println("PASS: Successfully found Home checkbox using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find Home checkbox using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 12: Find the main header using By.xpath")
    public void testMainHeader() {
        try {
            WebElement mainHeader = xpathLocators.getMainHeader();
            Assert.assertTrue(mainHeader.isDisplayed(), 
                             "Main header not found using XPath");
            System.out.println("PASS: Successfully found main header using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find main header using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 16: Find the expand all button using By.xpath")
    public void testExpandAllButton() {
        try {
            WebElement expandAllButton = xpathLocators.getExpandAllButton();
            Assert.assertTrue(expandAllButton.isDisplayed(), 
                             "Expand all button not found using XPath");
            System.out.println("PASS: Successfully found expand all button using XPath");
            
            // Click the button to verify it works
            expandAllButton.click();
        } catch (Exception e) {
            Assert.fail("Failed to find expand all button using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 24: Find the checkbox icon using By.xpath")
    public void testCheckboxIcon() {
        try {
            WebElement checkboxIcon = xpathLocators.getCheckboxIcon();
            Assert.assertTrue(checkboxIcon.isDisplayed(), 
                             "Checkbox icon not found using XPath");
            System.out.println("PASS: Successfully found checkbox icon using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find checkbox icon using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 31: Find the tree node using By.xpath")
    public void testTreeNode() {
        try {
            WebElement treeNode = xpathLocators.getTreeNode();
            Assert.assertTrue(treeNode.isDisplayed(), 
                             "Tree node not found using XPath");
            System.out.println("PASS: Successfully found tree node using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find tree node using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 33: Find the collapse all button using By.xpath")
    public void testCollapseAllButton() {
        try {
            // First expand all to make collapse button active
            xpathLocators.getExpandAllButton().click();
            
            WebElement collapseAllButton = xpathLocators.getCollapseAllButton();
            Assert.assertTrue(collapseAllButton.isDisplayed(), 
                             "Collapse all button not found using XPath");
            System.out.println("PASS: Successfully found collapse all button using XPath");
            
            // Click the button to verify it works
            collapseAllButton.click();
        } catch (Exception e) {
            Assert.fail("Failed to find collapse all button using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 39: Find the Downloads checkbox using By.xpath")
    public void testDownloadsCheckbox() {
        try {
            WebElement downloadsCheckbox = xpathLocators.getDownloadsCheckbox();
            Assert.assertTrue(downloadsCheckbox.isDisplayed(), 
                             "Downloads checkbox not found using XPath");
            System.out.println("PASS: Successfully found Downloads checkbox using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find Downloads checkbox using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 43: Find the Desktop checkbox using By.xpath")
    public void testDesktopCheckbox() {
        try {
            WebElement desktopCheckbox = xpathLocators.getDesktopCheckbox();
            Assert.assertTrue(desktopCheckbox.isDisplayed(), 
                             "Desktop checkbox not found using XPath");
            System.out.println("PASS: Successfully found Desktop checkbox using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find Desktop checkbox using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 49: Find the Documents checkbox using By.xpath")
    public void testDocumentsCheckbox() {
        try {
            WebElement documentsCheckbox = xpathLocators.getDocumentsCheckbox();
            Assert.assertTrue(documentsCheckbox.isDisplayed(), 
                             "Documents checkbox not found using XPath");
            System.out.println("PASS: Successfully found Documents checkbox using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find Documents checkbox using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 58: Find the toggle button for Home using By.xpath")
    public void testHomeToggleButton() {
        try {
            WebElement homeToggleButton = xpathLocators.getHomeToggleButton();
            Assert.assertTrue(homeToggleButton.isDisplayed(), 
                             "Home toggle button not found using XPath");
            System.out.println("PASS: Successfully found Home toggle button using XPath");
            
            // Click the button to verify it works
            homeToggleButton.click();
        } catch (Exception e) {
            Assert.fail("Failed to find Home toggle button using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 63: Find the result text area using By.xpath")
    public void testResultTextArea() {
        try {
            // First check a checkbox to make the result area appear
            xpathLocators.getCheckboxIcon().click();
            
            WebElement resultTextArea = xpathLocators.getResultTextArea();
            Assert.assertTrue(resultTextArea.isDisplayed(), 
                             "Result text area not found using XPath");
            System.out.println("PASS: Successfully found result text area using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find result text area using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 67: Find the Notes checkbox using By.xpath")
    public void testNotesCheckbox() {
        try {
            WebElement notesCheckbox = xpathLocators.getNotesCheckbox();
            Assert.assertTrue(notesCheckbox.isDisplayed(), 
                             "Notes checkbox not found using XPath");
            System.out.println("PASS: Successfully found Notes checkbox using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find Notes checkbox using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 69: Find the Desktop checkbox label using By.xpath")
    public void testDesktopCheckboxLabel() {
        try {
            WebElement desktopCheckboxLabel = xpathLocators.getDesktopCheckboxLabel();
            Assert.assertTrue(desktopCheckboxLabel.isDisplayed(), 
                             "Desktop checkbox label not found using XPath");
            System.out.println("PASS: Successfully found Desktop checkbox label using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find Desktop checkbox label using XPath: " + e.getMessage());
        }
    }

   @Test(description = "Exercise 74: Find the Commands checkbox using By.xpath")
   public void testCommandsCheckbox() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Target the checkbox input directly with its ID
        WebElement commandsCheckbox = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='tree-node-commands']"))
        );
        
        Assert.assertTrue(commandsCheckbox.isDisplayed(), 
                         "Commands checkbox not found using XPath");
        System.out.println("PASS: Successfully found Commands checkbox using XPath");
    } catch (Exception e) {
        Assert.fail("Failed to find Commands checkbox using XPath: " + e.getMessage());
    }
}

    @Test(description = "Exercise 80: Find the WorkSpace checkbox using By.xpath")
    public void testWorkSpaceCheckbox() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Target the workspace checkbox input directly with its ID
        WebElement workSpaceCheckbox = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='tree-node-workspace']"))
        );
        
        Assert.assertTrue(workSpaceCheckbox.isDisplayed(), 
                         "WorkSpace checkbox not found using XPath");
        System.out.println("PASS: Successfully found WorkSpace checkbox using XPath");
    } catch (Exception e) {
        Assert.fail("Failed to find WorkSpace checkbox using XPath: " + e.getMessage());
    }
}

    @Test(description = "Exercise 90: Find the Angular checkbox using By.xpath")
    public void testAngularCheckbox() {
        try {
            WebElement angularCheckbox = xpathLocators.getAngularCheckbox();
            Assert.assertTrue(angularCheckbox.isDisplayed(), 
                             "Angular checkbox not found using XPath");
            System.out.println("PASS: Successfully found Angular checkbox using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find Angular checkbox using XPath: " + e.getMessage());
        }
    }

    @Test(description = "Exercise 92: Find the React checkbox using By.xpath")
    public void testReactCheckbox() {
        try {
            WebElement reactCheckbox = xpathLocators.getReactCheckbox();
            Assert.assertTrue(reactCheckbox.isDisplayed(), 
                             "React checkbox not found using XPath");
            System.out.println("PASS: Successfully found React checkbox using XPath");
        } catch (Exception e) {
            Assert.fail("Failed to find React checkbox using XPath: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}