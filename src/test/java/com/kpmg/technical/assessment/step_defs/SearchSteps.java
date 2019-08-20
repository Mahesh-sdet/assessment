package com.kpmg.technical.assessment.step_defs;

import com.kpmg.technical.assessment.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSteps extends HomePage {

    private HomePage homepage;

    public SearchSteps(HomePage homepage) {
        this.homepage = homepage;
    }

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        assertThat(homepage.getCurrentUrl(), is(endsWith("johnlewis.com/")));
    }

    @When("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String product) {
        homepage.searchAnyProduct(product);
    }
}
