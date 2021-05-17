package co.com.sofka.controllers;

import co.com.sofka.pages.LoginPage;
import co.com.sofka.pages.ProductPage;
import co.com.sofka.utils.others.ScreenCapture;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class ControllerProduct {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public ControllerProduct(WebDriver driver){ this.driver = driver; }

    public void testCaseAddToCart(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        ScreenCapture screenCapture = new ScreenCapture(driver);
        ProductPage productPage = new ProductPage(driver);

        infoLogger.info("Click en el boton Add to cart...");
        productPage.clickAddToCartBtn(3);
        screenCapture.takeScreen("testCaseAddToCart","1.ProductPageScreen.png");

        infoLogger.info("Click en el carrito...");
        productPage.clickCartBtn();
        screenCapture.takeScreen("testCaseAddToCart","2.CartPageScreen.png");

    }

    public void addSuccess(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        ProductPage productPage = new ProductPage(driver);

        infoLogger.info("Agregando productos al carrito...");
        productPage.addProductSuccess();
    }
}
