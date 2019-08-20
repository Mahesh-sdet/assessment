package com.kpmg.technical.assessment.pages;

import com.kpmg.technical.assessment.driver.DriverManager;
import com.kpmg.technical.assessment.utils.RandomHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverManager {

    private static String productSelected = "";

    @FindBy(css = ".product-card__title-inner")
    private List<WebElement> productList;

    public List<String> getAllProductsFromList() {
        List<String> list = new ArrayList<>();
        for (WebElement product : productList) {
            list.add(product.getText());
        }
        if (list.size()==0){
            throw new RuntimeException("No Products found. ");
        }

        return list;
    }

    public void selectAnyProductFromList() {
        int randomNumber = new RandomHelper().numberGenerator(productList.size());
        productSelected = productList.get(randomNumber).getText();
        productList.get(randomNumber).click();
    }
}
