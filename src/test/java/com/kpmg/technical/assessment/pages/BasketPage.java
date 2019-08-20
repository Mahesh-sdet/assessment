package com.kpmg.technical.assessment.pages;

import com.kpmg.technical.assessment.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends DriverManager {

    @FindBy(id = "button--add-to-basket")
    private WebElement addBasketBtn;

    @FindBy(css = ".add-to-basket-view-basket-link")
    private WebElement goToBasketBtn;

    public void addProductToBasket() {
        addBasketBtn.click();
    }

    public void goToBasket() {
        waitForClickableOfElement(goToBasketBtn).click();
    }
}
