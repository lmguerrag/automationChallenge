package co.com.sofka.stepDefinitions;

import co.com.sofka.controllers.ControllerLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStep {

    private WebDriver driver;

    @Given("que un cliente quiere ingresar a la tienda")
    public void queUnClienteQuiereIngresarALaTienda() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }
    @When("ingresa las credenciales correctas")
    public void ingresaLasCredencialesCorrectas() {
        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.testCaseLoginSuccess();
    }
    @Then("accede a la tienda exitosamente")
    public void accedeALaTiendaExitosamente() {

    }
}
