package co.com.sofka.stepDefinitions;

import co.com.sofka.controllers.ControllerCart;
import co.com.sofka.controllers.ControllerLogin;
import co.com.sofka.controllers.ControllerProduct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SuccessfulPurchaseStep {

    private WebDriver driver;

    @Given("un cliente quiere comprar productos")
    public void unClienteQuiereComprarProductos() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.loginSuccess();
    }
    @Given("agrego productos al carrito")
    public void agregoProductosAlCarrito() {
        ControllerProduct controllerProduct = new ControllerProduct(driver);
        controllerProduct.addSuccess();
    }
    @When("valide sus datos")
    public void valideSusDatos() {
        ControllerCart controllerCart = new ControllerCart(driver);
        controllerCart.testCaseSuccessfulPurchase();
    }

    @Then("su compra fue completada")
    public void suCompraFueCompletada() {
        ControllerCart controllerCart = new ControllerCart(driver);
    }

}

