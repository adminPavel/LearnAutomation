package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    private final By searchField = By.name("q");
   // @FindBy (id = "Selenium")
   // private WebElement searchField;
public SearchPage() { super(); }
    public void fillTheSearchField (String keyword) {
    WebElement searchFieldElement = webDriver.findElement(searchField);
        searchFieldElement.click();
        searchFieldElement.sendKeys(keyword);
    }
    public void pressEnter() {
    WebElement searchFieldElement = webDriver.findElement(searchField);
        searchFieldElement.sendKeys(Keys.RETURN);
    }
}
