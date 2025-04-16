package ctrl.alt.del.g1thub.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Factory class to create WebDriver instances
 * This utility class helps manage browser drivers across the test suite
 */
public class WebDriverFactory {
    
    /**
     * Get a WebDriver instance based on browser name
     * @param browser Name of the browser (chrome, firefox, edge, safari)
     * @param headless Whether to run in headless mode
     * @return WebDriver instance
     */
    public static WebDriver getDriver(String browser, boolean headless) {
        WebDriver driver;
        
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
                
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
                
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;
                
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
                
            default:
                // Default to Chrome if browser not specified or not recognized
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        
        // Maximize window and set implicit wait
        driver.manage().window().maximize();
        return driver;
    }
    
    /**
     * Get a Chrome WebDriver instance with default settings
     * @return Chrome WebDriver instance
     */
    public static WebDriver getDefaultDriver() {
        return getDriver("chrome", false);
    }
    
    /**
     * Get a headless Chrome WebDriver instance for CI/CD environments
     * @return Headless Chrome WebDriver instance
     */
    public static WebDriver getHeadlessDriver() {
        return getDriver("chrome", true);
    }
}