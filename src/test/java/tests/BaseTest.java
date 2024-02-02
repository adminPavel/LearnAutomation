package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;

import java.io.File;

public abstract class BaseTest {
    private static WebDriver webDriver;
    SearchSteps steps;
    @BeforeClass
    public void setUp () {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com/");
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }

    @AfterMethod
    public void goBack(){
        webDriver.navigate().back();
    }
    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"selenium"}, {"selenium javascript"}};
    }
}
