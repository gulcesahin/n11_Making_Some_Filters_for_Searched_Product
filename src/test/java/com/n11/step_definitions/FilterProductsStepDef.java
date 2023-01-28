package com.n11.step_definitions;

import com.n11.pages.BasePage;
import com.n11.pages.SearchPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class FilterProductsStepDef {

    BasePage basePage= new BasePage();
    SearchPage searchPage= new SearchPage();


    @Given("User opens the browser and goes to the home page and searches for the product {string} on the search bar")
    public void userOpensTheBrowserAndGoesToTheHomePageAndSearchesForTheProductOnTheSearchBar(String product) throws InterruptedException {
        basePage.goToTheUrl();
        basePage.searchProduct(product);
        searchPage.checkSearchedProductIsCorrect();
    }


    @When("User selects some filters")
    public void userSelectsSomeFilters() {
        searchPage.closeCookies();
        searchPage.setFilter();
    }

    @Then("User sees that filters are okay")
    public void userSeesThatFiltersAreOkay() {
        searchPage.checkFiltersAreOkay();
    }
}
