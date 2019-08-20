package com.kpmg.technical.assessment.step_defs;

import com.kpmg.technical.assessment.pages.ResultsPage;
import cucumber.api.java.en.Then;

public class ResultsSteps {

    private ResultsPage resultspage;

    public ResultsSteps(ResultsPage resultspage) {
        this.resultspage = resultspage;
    }

    @Then("^I select any product from list$")
    public void i_select_a_product_from_list() {
        resultspage.selectAnyProductFromList();
    }
}
