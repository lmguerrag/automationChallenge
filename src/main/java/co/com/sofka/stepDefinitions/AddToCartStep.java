package co.com.sofka.stepDefinitions;

import co.com.sofka.controllers.ControllerLogin;
import co.com.sofka.controllers.ControllerHome;
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

public class AddToCartStep {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    @Given("un cliente quiere agregar productos que le gustan al carrito")
    public void un_cliente_quiere_agregar_productos_que_le_gustan_al_carrito() {
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        infoLogger.info("INICIANDO ADD TO CART TEST...");
        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.loginSuccess();

    }
    @When("agrega uno o mas productos")
    public void agrega_uno_o_mas_productos() {
        ControllerHome controllerHome = new ControllerHome(driver);
        controllerHome.testCaseAddToCart();
    }
    @Then("podra ver los productos en el carrito de compras")
    public void podra_ver_los_productos_en_el_carrito_de_compras() {
        ControllerHome controllerHome = new ControllerHome(driver);
        controllerHome.validateTestCaseAddToCart();
        driver.quit();
    }
}
