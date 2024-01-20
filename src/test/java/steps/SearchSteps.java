package steps;


import pages.SearchPage;

public class SearchSteps {
    private SearchPage searchPage = new SearchPage();
    public SearchResultsSteps searchByKeyword (String keyword) {
    searchPage.fillTheSearchField(keyword);
    searchPage.pressEnter();
    return new SearchResultsSteps();
    }
}
