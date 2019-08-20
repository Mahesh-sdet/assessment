package com.kpmg.technical.assessment.pages;

import com.kpmg.technical.assessment.driver.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverManager {

    @FindBy(xpath = "//input[@id='desktopSearch']")
    private WebElement searchTxtBx;

    public void searchAnyProduct(String product){
        searchTxtBx.sendKeys(product);
        searchTxtBx.sendKeys(Keys.ENTER);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
