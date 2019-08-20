package com.kpmg.technical.assessment.step_defs;

import com.kpmg.technical.assessment.model.DeliveryDetails;
import com.kpmg.technical.assessment.pages.DeliveryChoicePage;
import com.kpmg.technical.assessment.pages.ReviewAndPayPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DeliverySteps {

    private DeliveryChoicePage deliverychoice;
    private ReviewAndPayPage reviewAndPayPage;

    public DeliverySteps(DeliveryChoicePage deliverychoice, ReviewAndPayPage reviewAndPayPage) {
        this.deliverychoice = deliverychoice;
        this.reviewAndPayPage = reviewAndPayPage;
    }

    @And("^I click on delivery$")
    public void iClickOnDelivery() {
        deliverychoice.selectDeliveryMethod();
    }

    @Then("^I enter delivery details as below:$")
    public void i_enter_delivery_details_as_below(List<DeliveryDetails> deliverydetails) {
        deliverychoice.fillDeliveryForm(deliverydetails.get(0));
        deliverychoice.selectAddressFromListOfPostcode();
    }

    @Then("^I select delivery option as \"([^\"]*)\"$")
    public void i_select_delivery_option_as(String option) {
        deliverychoice.selectDeliveryOptionAvailable(option);
    }

    @And("^I select delivery date to be \"([^\"]*)\" day of current date and proceed to payment$")
    public void iSelectDeliveryDateToBeDayOfCurrentDate(int daysPlus) {
        deliverychoice.setDeliveryDateToBe(daysPlus);
    }

    @Then("^I should validate the delivery details:$")
    public void i_should_validate_the_delivery_details(List<String> keys) {
        Map<String, String> actualMap = reviewAndPayPage.getDeliveryMethodDetails();
        Map<String, String> expectedMap = DeliveryChoicePage.selectedDeliveryDetailsMap;
        assertThat(actualMap.get(keys.get(0)), containsString(expectedMap.get(keys.get(0)) + " BETWEEN 7.30AM - 6PM"));
        assertThat(actualMap.get(keys.get(1)), is(equalToIgnoringCase(expectedMap.get(keys.get(1)))));
    }
}
