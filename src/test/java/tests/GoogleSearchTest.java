package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.time.Duration;
import java.util.*;

import static org.testng.Assert.fail;

public class GoogleSearchTest {
    private WebDriver driver;
    public String name = "Куркумас";

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src\\test\\java" + File.separator;
        String clDir = tests.GoogleSearchTest.class.getName().replace(tests.GoogleSearchTest.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    @BeforeTest
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", dir() + "chromedriver.exe");

        // Create a new instance of ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Find the search box element
        WebElement searchBox = driver.findElement(By.name("q"));

        // Enter a search query
        searchBox.sendKeys(name);

        // Submit the search query
        searchBox.submit();

        // Wait for the search results to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//TimeSpan.FromSeconds(10)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search")));

        // Find all search result links
        WebElement resultLinks = driver.findElement(By.cssSelector("#search"));
        List<WebElement> links = resultLinks.findElements(By.cssSelector("div[class*='MjjYud']"));

        // Check if all search result links contain the keyword "selenium"
        for (WebElement link : links) {
            String linkText = link.getText();
            if (!linkText.contains(name)) {
                fail("Search result link does not contain the keyword "+ name + " : " + linkText);
            }
        }
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}