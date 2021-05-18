package co.com.sofka.stepDefinitions;

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

public class LoginStep {

    private WebDriver driver;

    @Given("^que un usuario quiere ingresar a la tienda$")
    public void queUnUsuarioQuiereIngresarALaTienda() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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

}
