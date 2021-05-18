package co.com.sofka.stepDefinitions;

import co.com.sofka.controllers.ControllerCart;
import co.com.sofka.controllers.ControllerLogin;
import co.com.sofka.controllers.ControllerProduct;
import co.com.sofka.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Value;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SuccessfulPurchaseStep {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    @Given("un cliente quiere comprar productos")
    public void unClienteQuiereComprarProductos() {
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        infoLogger.info("INICIANDO PURCHASE TEST...");
        if(System.getProperty("user.browser") == "firefox"){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.saucedemo.com/");
        }
        else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.saucedemo.com/");
        }

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
        controllerCart.testCaseSuccessfulPurchase(false);
    }

    @Then("su compra fue completada")
    public void suCompraFueCompletada() {
        ControllerCart controllerCart = new ControllerCart(driver);
        controllerCart.ValidateTestCaseSuccessfulPurchase();
        driver.quit();
    }

}

