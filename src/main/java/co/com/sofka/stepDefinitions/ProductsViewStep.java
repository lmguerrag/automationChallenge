package co.com.sofka.stepDefinitions;

import co.com.sofka.controllers.ControllerHome;
import co.com.sofka.controllers.ControllerLogin;
import co.com.sofka.pages.LoginPage;
import co.com.sofka.utils.others.SelectDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProductsViewStep {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    @Given("un usuario quiere ver los productos")
    public void unUsuarioQuiereVerLosProductos() {
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        SelectDriver selectDriver = new SelectDriver(driver);
        /**
         * Seleccionar el browser entre 'chrome' o 'firefox'
         */
        driver = selectDriver.selectBrowser("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        infoLogger.info("INICIANDO PRODUCTS VIEW TEST...");
    }
    @When("ingresa a la tienda")
    public void ingresaALaTienda() {
        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.loginSuccess();
    }
    @Then("se visualizan los productos correctamente")
    public void seVisualizanLosProductosCorrectamente() {
        ControllerHome controllerHome = new ControllerHome(driver);
        controllerHome.validateIfTheProductWereUploaded();
        driver.quit();
    }
}
