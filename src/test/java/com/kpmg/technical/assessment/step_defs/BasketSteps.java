package com.kpmg.technical.assessment.step_defs;

import com.kpmg.technical.assessment.pages.BasketPage;
import cucumber.api.java.en.Then;

public class BasketSteps {

    private BasketPage basketpage;

    public BasketSteps(BasketPage basketpage) {
        this.basketpage = basketpage;
    }

    @Then("^I add product to basket$")
    public void i_add_product_to_basket() {
        basketpage.addProductToBasket();
    }

    @Then("^I go to basket$")
    public void i_click_on_basket_button() {
        basketpage.goToBasket();
    }
}
