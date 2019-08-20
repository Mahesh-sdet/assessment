package com.kpmg.technical.assessment.pages;

import com.kpmg.technical.assessment.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class ReviewAndPayPage extends DriverManager {

    @FindBy(css = "p[data-test='delivery-details-message']")
    private WebElement deliveryDateAndTime;

    @FindBy(css = "dt[data-test='delivery-details-title']")
    private WebElement deliverTitle;

    public Map<String, String> getDeliveryMethodDetails() {
        sleep(5000);
        Map<String, String> deliveryMethodMap = new HashMap<>();
        deliveryMethodMap.put("DeliveryOptions", deliverTitle.getText().toUpperCase());
        deliveryMethodMap.put("DeliveryDate", deliveryDateAndTime.getText().toUpperCase());
        return deliveryMethodMap;
    }
}
