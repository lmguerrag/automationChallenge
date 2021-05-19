package co.com.sofka.controllers;

import co.com.sofka.pages.LoginPage;
import co.com.sofka.pages.HomePage;
import co.com.sofka.pages.cartForm.CartPage;
import co.com.sofka.utils.others.ScreenCapture;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerHome {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public ControllerHome(WebDriver driver){ this.driver = driver; }

    public void testCaseAddToCart(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        ScreenCapture screenCapture = new ScreenCapture(driver);
        HomePage homePage = new HomePage(driver);

        infoLogger.info("Click en el boton Add to cart...");
        homePage.clickAddToCartBtn(3);
        screenCapture.takeScreen("testCaseAddToCart","1.HomePageScreen.png");

        infoLogger.info("Click en el carrito...");
        homePage.clickCartBtn();
        screenCapture.takeScreen("testCaseAddToCart","2.CartPageScreen.png");
    }

    public void testCaseLogout(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        ScreenCapture screenCapture = new ScreenCapture(driver);
        HomePage homePage = new HomePage(driver);

        infoLogger.info("Click en el menu de opciones...");
        homePage.clickOptionsMenu();
        screenCapture.takeScreen("testCaseLogout","1.HomePageScreen.png");

        infoLogger.info("Click en el boton logout...");
        homePage.clickLogoutBtn();
        screenCapture.takeScreen("testCaseLogout","2.LoginPageScreen.png");
    }

    public void addSuccess(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        HomePage homePage = new HomePage(driver);

        infoLogger.info("Agregando productos al carrito...");
        homePage.addProductSuccess();
    }

    public void moveToCart(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        HomePage homePage = new HomePage(driver);

        infoLogger.info("Moviendose al carro de compras...");
        homePage.clickCartBtn();
    }

    public void validateTestCaseAddToCart(){
        infoLogger.info("Comparando resultados...");
        try{
            CartPage cartPage = new CartPage(driver);
            assertEquals("Sauce Labs Bolt T-Shirt", cartPage.getProductName());
        } catch (NoSuchElementException exception) {
            infoLogger.error("ERROR, NO SE ENCONTRO EL ELEMENTO");
        }
    }

    public void validateTestCaseLogout(){
        infoLogger.info("Comparando resultados...");
        try{
            LoginPage loginPage = new LoginPage(driver);
            assertEquals("Login", loginPage.getLoginBtnText());
        } catch (NoSuchElementException exception) {
            infoLogger.error("ERROR, NO SE ENCONTRO EL ELEMENTO");
        }
    }

    public void validateIfTheProductWereUploaded(){
        infoLogger.info("Comparando resultados...");
        try{
            HomePage homePage = new HomePage(driver);
            ScreenCapture screenCapture = new ScreenCapture(driver);
            screenCapture.takeScreen("testCaseProductsView","1.HomePageScreen.png");
            assertEquals(6, homePage.getAmountOfDisplayedProducts());

        } catch (NoSuchElementException exception) {
            infoLogger.error("ERROR");
        }
    }
}
