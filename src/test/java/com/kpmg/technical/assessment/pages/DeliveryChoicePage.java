package com.kpmg.technical.assessment.pages;

import com.kpmg.technical.assessment.driver.DriverManager;
import com.kpmg.technical.assessment.model.DeliveryDetails;
import com.kpmg.technical.assessment.utils.DateHelper;
import com.kpmg.technical.assessment.utils.RandomHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryChoicePage extends DriverManager {

    @FindBy(css = "button[data-id='delivery']")
    private WebElement deliveryMethod;

    @FindBy(id = "title")
    private WebElement tileTxtBx;

    @FindBy(id = "firstName")
    private WebElement firstnameTxtBx;

    @FindBy(id = "lastName")
    private WebElement lastnameTxtBx;

    @FindBy(id = "phoneNumber-number")
    private WebElement phonenumberTxtBx;

    @FindBy(id = "searchPostcode")
    private WebElement postcodeTxtbx;

    @FindBy(css = "button[data-test='postcodeSearchForm-submit']")
    private WebElement findAddressBtn;

    @FindBy(id = "addressSearchSelect")
    private WebElement addressDdl;

    @FindBy(css = "button[data-test='delivery-address-use-address']")
    private WebElement useThisAddressBtn;

    @FindBy(css = "span[class^='delivery-method_message__']")
    private List<WebElement> deliveryAvailableOptions;

    @FindBy(css = "button[type='submit']")
    private WebElement continueToPayMentBtn;

    public static Map<String, String> selectedDeliveryDetailsMap = new HashMap<>();

    public void selectDeliveryMethod() {
        waitForClickableOfElement(deliveryMethod).click();
    }

    public void fillDeliveryForm(DeliveryDetails deliverydetails) {
        tileTxtBx.sendKeys(deliverydetails.getTitle());
        firstnameTxtBx.sendKeys(deliverydetails.getFirstName());
        lastnameTxtBx.sendKeys(deliverydetails.getLastName());
        phonenumberTxtBx.sendKeys(deliverydetails.getPhoneNumber());
        postcodeTxtbx.sendKeys(deliverydetails.getPostCode());
        findAddressBtn.click();
    }

    public void selectAddressFromListOfPostcode() {
        waitForClickableOfElement(addressDdl);
        int itemsSize = addressDdl.findElements(By.tagName("option")).size();
        new Select(addressDdl).selectByValue(String.valueOf(new RandomHelper().numberGenerator(itemsSize)));
        waitForClickableOfElement(useThisAddressBtn).click();
    }

    public void selectDeliveryOptionAvailable(String option) {
        sleep(5000);
        boolean selected = false;
        for (WebElement deliveryAvailableOption : deliveryAvailableOptions) {
            if (deliveryAvailableOption.getText().equalsIgnoreCase(option)) {
                selected = true;
                deliveryAvailableOption.click();
                selectedDeliveryDetailsMap.put("DeliveryOptions", option.toUpperCase());
                break;
            }
        }
        if (!selected) {
            throw new RuntimeException(String.format("%s <==> options is not selected", option.toUpperCase()));
        }
    }

    public void setDeliveryDateToBe(int dateToBe) {
        String selectedDate = new DateHelper().getFutureDateBy(dateToBe);
        selectedDeliveryDetailsMap.put("DeliveryDate", new DateHelper().getFormattedDate(selectedDate));
        driver.findElement(By.cssSelector("button[data-id='" + selectedDate + "']")).click();
        waitForClickableOfElement(continueToPayMentBtn).click();
    }
}
