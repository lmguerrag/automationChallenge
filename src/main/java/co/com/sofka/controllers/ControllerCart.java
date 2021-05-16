package co.com.sofka.controllers;

import co.com.sofka.pages.CartPage;
import org.openqa.selenium.WebDriver;

public class ControllerCart {

    private WebDriver driver;

    public ControllerCart(WebDriver driver){
        this.driver = driver;
    }

    public void checkoutPurchase(){
        CartPage cartPage = new CartPage(driver);

        cartPage.clickCheckoutBtn();
    }
}
