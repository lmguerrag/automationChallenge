package co.com.sofka.controllers;

import co.com.sofka.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class ControllerProduct {

    private WebDriver driver;

    public ControllerProduct(WebDriver driver){ this.driver = driver; }

    public void testCaseAddToCart(){
        ProductPage productPage = new ProductPage(driver);

        productPage.clickAddToCartBtn(3);
        productPage.clickCartBtn();
    }
}
