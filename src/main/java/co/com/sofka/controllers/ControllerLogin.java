package co.com.sofka.controllers;

import co.com.sofka.pages.LoginPage;
import co.com.sofka.pages.HomePage;
import co.com.sofka.utils.others.ScreenCapture;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerLogin {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public ControllerLogin(WebDriver driver){
        this.driver = driver;
    }

    public void testCaseLoginSuccess(String userType, String username, String password){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        infoLogger.info("INICIANDO LOGIN " + userType.toUpperCase() + " TEST...");
        LoginPage loginPage = new LoginPage(driver);
        ScreenCapture screenCapture = new ScreenCapture(driver);

        infoLogger.info("Ingresando username...");
        loginPage.setUsernameField(username);

        infoLogger.info("Ingresando password...");
        loginPage.setPasswordField(password);
        screenCapture.takeScreen("testCaseLogin\\" + userType,"1.LoginPageScreen.png");

        infoLogger.info("Click en el boton login...");
        loginPage.clickLoginBtn();
        screenCapture.takeScreen("testCaseLogin\\" + userType,"2.HomePageScreen.png");
    }

    public void testCaseLockedUser(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        infoLogger.info("INICIANDO LOGIN FAIL TEST...");
        LoginPage loginPage = new LoginPage(driver);
        ScreenCapture screenCapture = new ScreenCapture(driver);

        infoLogger.info("Ingresando username...");
        loginPage.setUsernameField("locked_out_user");

        infoLogger.info("Ingresando password...");
        loginPage.setPasswordField("secret_sauce");
        screenCapture.takeScreen("testCaseLogin\\locked","1.LoginPageScreen.png");

        infoLogger.info("Click en el boton login...");
        loginPage.clickLoginBtn();
        screenCapture.takeScreen("testCaseLogin\\locked","2.LoginLockedPageScreen.png");
    }

    public void testCaseLoginFail(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        infoLogger.info("INICIANDO LOGIN FAIL TEST...");
        LoginPage loginPage = new LoginPage(driver);
        ScreenCapture screenCapture = new ScreenCapture(driver);

        infoLogger.info("Ingresando username...");
        loginPage.setUsernameField("usuario_incorrecto_o_vacio");

        infoLogger.info("Ingresando password...");
        loginPage.setPasswordField("password_incorrecto_o_vacio");
        screenCapture.takeScreen("testCaseLogin\\fail","1.LoginPageScreen.png");

        infoLogger.info("Click en el boton login...");
        loginPage.clickLoginBtn();
        screenCapture.takeScreen("testCaseLogin\\fail","2.LoginFailPageScreen.png");
    }

    public void loginSuccess(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        LoginPage loginPage = new LoginPage(driver);

        infoLogger.info("Realizando login...");
        loginPage.loginSuccessful();
    }

    public void validateTestCaseLoginLockedUser(){
        infoLogger.info("Comparando resultados...");
        try{
            LoginPage loginPage = new LoginPage(driver);
            assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
        } catch (NoSuchElementException exception) {
            infoLogger.error("ERROR");
            exception.printStackTrace();
        }
    }

    public void validateTestCaseLoginFail(){
        infoLogger.info("Comparando resultados...");
        try{
            LoginPage loginPage = new LoginPage(driver);
            assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
        } catch (NoSuchElementException exception) {
            infoLogger.error("ERROR");
            exception.printStackTrace();
        }
    }

    public void validateTestCaseLoginSuccess(){
        infoLogger.info("Comparando resultados...");
        try{
            HomePage homePage = new HomePage(driver);
            assertEquals("PRODUCTS", homePage.getTitlePage());
        } catch (NoSuchElementException exception) {
            infoLogger.error("ERROR, EL USUARIO NO PUDO ACCEDER, POR LO QUE NO SE ENCONTRO EL ELEMENTO");
            exception.printStackTrace();
        }
    }

}
