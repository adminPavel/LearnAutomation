package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.SearchPage;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SearchTest extends BaseTest{


 @Test(dataProvider = "dataProvider")
 public void openGoogleComInChromeTest1(String text) throws InterruptedException{
  SearchPage searchPage = new SearchPage();
  searchPage.fillTheSearchField(text);
  searchPage.pressEnter();
  Thread.sleep(3000);
  WebElement resultRow = getWebDriver().findElement(By.xpath("//div[@class='g']//h3"));
  assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();
  assertThat(resultRow.getText()).as("Wrong text has been displayed!").isEqualTo("Selenium WebDriver - Selenium Document");

 }


 }

