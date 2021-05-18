package co.com.sofka.stepDefinitions;

import co.com.sofka.controllers.ControllerCart;
import co.com.sofka.controllers.ControllerHome;
import co.com.sofka.controllers.ControllerLogin;
import co.com.sofka.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RemoveStep {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    @Given("un usuario quiere eliminar un producto agregado al carrito")
    public void unUsuarioQuiereEliminarUnProductoAgregadoAlCarrito() {
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        infoLogger.info("INICIANDO REMOVE TEST...");

        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.loginSuccess();
        ControllerHome controllerHome = new ControllerHome(driver);
        controllerHome.addSuccess();
    }
    @When("elimine el producto del carrito")
    public void elimineElProductoDelCarrito() {
        ControllerCart controllerCart = new ControllerCart(driver);
        controllerCart.testCaseRemoveProductFromTheCart();
    }
    @Then("el producto no se visualizara en el carrito")
    public void elProductoNoSeVisualizaraEnElCarrito() {
        ControllerCart controllerCart = new ControllerCart(driver);
        controllerCart.validateTestCaseRemove();
        driver.quit();
    }
}
