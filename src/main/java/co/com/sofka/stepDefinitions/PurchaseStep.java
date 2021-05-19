package co.com.sofka.stepDefinitions;

import co.com.sofka.controllers.ControllerCart;
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

public class PurchaseStep {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    @Given("un cliente quiere comprar productos")
    public void unClienteQuiereComprarProductos() {
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        SelectDriver selectDriver = new SelectDriver(driver);
        /**
         * Seleccionar el browser entre 'chrome' o 'firefox'
         */
        driver = selectDriver.selectBrowser("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        infoLogger.info("INICIANDO PURCHASE TEST...");

        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.loginSuccess();
    }
    @When("agrego productos al carrito")
    public void agregoProductosAlCarrito() {
        ControllerHome controllerHome = new ControllerHome(driver);
        controllerHome.addSuccess();
    }
    @When("valide sus datos")
    public void valideSusDatos() {
        ControllerCart controllerCart = new ControllerCart(driver);
        /**
         * 'true' para obtener los datos de la database, y 'false' para generar los datos con javafaker
         */
        controllerCart.testCaseSuccessfulPurchase(true, "successful");
    }

    @Then("su compra fue completada")
    public void suCompraFueCompletada() {
        ControllerCart controllerCart = new ControllerCart(driver);
        controllerCart.validateTestCaseSuccessfulPurchase();
        driver.quit();
    }

    @When("no agrega productos al carro")
    public void noAgregaProductosAlCarro() {
        ControllerHome controllerHome = new ControllerHome(driver);
        controllerHome.moveToCart();
    }

    @When("valide sus datos sin productos en el carro")
    public void valideSusDatosSinProductosEnElCarro() {
        ControllerCart controllerCart = new ControllerCart(driver);
        /**
         * 'true' para obtener los datos de la database, y 'false' para generar los datos con javafaker
         */
        controllerCart.testCaseSuccessfulPurchase(true, "withoutProducts");
    }

    @Then("su compra fue fallida")
    public void suCompraFueFallida() {
        ControllerCart controllerCart = new ControllerCart(driver);
        controllerCart.validateTestCasePurchaseWithoutProducts();
        driver.quit();
    }
}

