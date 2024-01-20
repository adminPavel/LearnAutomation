package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SearchResultPage extends BasePage{
    @FindBy(xpath = "//cite[@class='iUh30']")
     private List<WebElement> searchResultURLs;
    public SearchResultPage(){super();}
    public void assertThatExpectedValueIsOnSearchTop (String expectedValue) {
        assertEquals(searchResultURLs.get(0).getText(), "expectedValue",
                expectedValue + "is not the first result!");

    }
}
