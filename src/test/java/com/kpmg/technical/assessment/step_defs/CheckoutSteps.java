package com.kpmg.technical.assessment.step_defs;

import com.kpmg.technical.assessment.pages.CheckoutPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CheckoutSteps {

    private CheckoutPage checkoutpage;

    public CheckoutSteps(CheckoutPage checkoutpage) {
        this.checkoutpage = checkoutpage;
    }

    @And("^I click on guest checkout$")
    public void iClickOnGuestCheckout() {
        checkoutpage.selectSecureCheckoutOption();
    }

    @And("^I will enter email \"([^\"]*)\"$")
    public void iWillEnterEmail(String email) {
        checkoutpage.enterEmailInGuestCheckout(email);
    }

    @Then("^I continue as guest$")
    public void i_click_on_continue_as_guest_button() {
        checkoutpage.clickOnContinueAsGuest();
    }

    @And("^I click on checkout button$")
    public void iClickOnCheckoutButton() {
        checkoutpage.goToCheckout();
    }
}
