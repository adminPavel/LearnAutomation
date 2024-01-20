package steps;

import pages.SearchResultPage;

public class SearchResultsSteps {
    private SearchResultPage searchResultPage = new SearchResultPage();
    public SearchResultsSteps verifyThatTopValueIsCorrect (String expectedValue) {
        searchResultPage.assertThatExpectedValueIsOnSearchTop(expectedValue);
        return this;
    }
}
