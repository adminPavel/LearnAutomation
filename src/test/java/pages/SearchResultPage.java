package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;
import static tests.BaseTest.getWebDriver;

public class SearchResultPage extends BasePage{
    @FindBy(xpath = "//cite[@class='iUh30']")
     private List<WebElement> searchResultURLs;
    public SearchResultPage(){super();}
    public void assertThatTopResultContainsCorrectText (String expectedValue) {
        WebElement resultRowElement = getWebDriver().findElement(By.xpath("//div[@class='g']//h3"));
        assertThat(resultRowElement.isDisplayed()).as("Element has not been displayed!").isTrue();
        assertThat(resultRowElement.getText()).as("Wrong text has been displayed!").isEqualTo("Selenium");

//        assertEquals(searchResultURLs.get(0).getText(), "expectedValue",
//                expectedValue + "is not the first result!");
    }
    public void assertThatTopResultContainsProperAttributeText (String expectedValue) {
        WebElement resultRowElement = getWebDriver().findElement(By.xpath("//div[@class='g']//h3"));
         assertThat(resultRowElement.getAttribute("class")).as("Wrong attribute text!").contains("LC201b");

    }
}
