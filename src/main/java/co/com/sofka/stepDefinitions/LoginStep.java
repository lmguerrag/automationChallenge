package co.com.sofka.stepDefinitions;

import co.com.sofka.controllers.ControllerLogin;
import co.com.sofka.utils.others.SelectDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStep {

    private WebDriver driver;

    @Given("^que un usuario quiere ingresar a la tienda$")
    public void queUnUsuarioQuiereIngresarALaTienda() {
        SelectDriver selectDriver = new SelectDriver(driver);
        /**
         * Seleccionar el browser entre 'chrome' o 'firefox'
         */
        driver = selectDriver.selectBrowser("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }
    @When("^el usuario ([^\"]*) ingresa usuario ([^\"]*) y password ([^\"]*)$")
    public void elUsuarioingresaUsernameYPassword(String userType, String username, String password) {
        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.testCaseLoginSuccess(userType, username, password);
    }
    @Then("accede a la tienda")
    public void accedeALaTienda() {
        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.validateTestCaseLoginSuccess();
        driver.quit();
    }

    @When("ingresa las credenciales siendo un usuario bloqueado")
    public void ingresaLasCredencialesSiendoUnUsuarioBloqueado() {
        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.testCaseLockedUser();
    }
    @Then("se le negara el acceso a la tienda")
    public void seLeNegaraElAccesoALaTienda() {
        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.validateTestCaseLoginLockedUser();
        driver.quit();
    }

    @When("el usuario ingresa credenciales incorrectos")
    public void elUsuarioIngresaCredencialesIncorrectos() {
        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.testCaseLoginFail();
    }
    @Then("no podra acceder a la tienda")
    public void noPodraAccederALaTienda() {
        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.validateTestCaseLoginFail();
        driver.quit();
    }
}
