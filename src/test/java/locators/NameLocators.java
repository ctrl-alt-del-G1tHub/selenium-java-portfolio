package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocators {
    private WebDriver driver;
    
    public NameLocators(WebDriver driver) {
        this.driver = driver;
    }
    
    // Exercise 1: Find the "First Name" Input using By.name
    public WebElement getFirstName() {
        return driver.findElement(By.name("firstname"));
    }
    
    // Exercise 11: Find the input field for "Last Name" using By.name  
    public WebElement getLastName() {
        return driver.findElement(By.name("lastname"));
    }
    
    // Exercise 27: Find the "Submit Button" using By.name 
    public WebElement getSubmitButton() {
        return driver.findElement(By.name("submit"));
    }
    
    // Exercise 38: Find the "Profession (Manual Tester)" using By.name  
    public WebElement getProfessionSelect() {
        return driver.findElement(By.name("profession"));
    }
    
    // Exercise 75: Find the "Automation Tool (Selenium Webdriver)" using By.name 
    public WebElement getAutomationTool() {
        return driver.findElement(By.name("tool"));
    }
    
    // Exercise 82: Find the "Continent" dropdown field using By.name
    public WebElement getContinentDropdown() {
        return driver.findElement(By.name("continents"));
    }
    
    // Exercise 97: Find the "Selenium Commands Multi-Select" using By.name
    public WebElement getSeleniumCommands() {
        return driver.findElement(By.name("selenium_commands"));
    }
    
   }
