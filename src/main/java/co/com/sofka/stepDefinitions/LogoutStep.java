package co.com.sofka.stepDefinitions;

import co.com.sofka.controllers.ControllerHome;
import co.com.sofka.controllers.ControllerLogin;
import co.com.sofka.pages.LoginPage;
import co.com.sofka.utils.others.SelectDriver;
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

public class LogoutStep {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    @Given("un usuario logeado quiere cerrar sesion")
    public void unUsuarioLogeadoQuiereCerrarSesion() {
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        SelectDriver selectDriver = new SelectDriver(driver);
        /**
         * Seleccionar el browser entre 'chrome' o 'firefox'
         */
        driver = selectDriver.selectBrowser("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        infoLogger.info("INICIANDO LOGOUT TEST...");

        ControllerLogin controllerLogin = new ControllerLogin(driver);
        controllerLogin.loginSuccess();
    }
    @When("click en logout")
    public void clickEnLogout() {
        ControllerHome controllerHome = new ControllerHome(driver);
        controllerHome.testCaseLogout();
    }
    @Then("cerrara sesion")
    public void cerraraSesion() {
        ControllerHome controllerHome = new ControllerHome(driver);
        controllerHome.validateTestCaseLogout();
        driver.quit();
    }
}
