package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static tests.BaseTest.getWebDriver;

public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage() {
        this.webDriver = getWebDriver();
        PageFactory.initElements(webDriver, this);
    }
}
