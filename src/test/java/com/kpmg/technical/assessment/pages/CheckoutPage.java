package com.kpmg.technical.assessment.pages;

import com.kpmg.technical.assessment.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends DriverManager {

    @FindBy(css = "label[for='guest:true']")
    private WebElement secureCheckoutBtn;

    @FindBy(id = "email")
    private WebElement emailTxtBx;

    @FindBy(css = ".button_c-button__fe2f1")
    private WebElement continueToGuestBtn;

    @FindBy(css = ".checkout-button")
    private WebElement checkoutBtn;

    public void selectSecureCheckoutOption() {
        waitForClickableOfElement(secureCheckoutBtn).click();
    }

    public void enterEmailInGuestCheckout(String email) {
        emailTxtBx.sendKeys(email);
    }

    public void clickOnContinueAsGuest() {
        continueToGuestBtn.click();
    }

    public void goToCheckout() {
        checkoutBtn.click();
    }
}
