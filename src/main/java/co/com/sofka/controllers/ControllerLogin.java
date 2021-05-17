package co.com.sofka.controllers;

import co.com.sofka.dto.UserDTO;
import co.com.sofka.pages.LoginPage;
import co.com.sofka.utils.database.Mapper;
import co.com.sofka.utils.others.ScreenCapture;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ControllerLogin {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public ControllerLogin(WebDriver driver){
        this.driver = driver;
    }

    public void testCaseLoginSuccess(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        LoginPage loginPage = new LoginPage(driver);
        ScreenCapture screenCapture = new ScreenCapture(driver);
        Mapper mapper = new Mapper();
        List<UserDTO> clientDTOS = mapper.createDTO();
        String username = clientDTOS.get(0).getUsername();
        String password = clientDTOS.get(0).getPassword();

        infoLogger.info("Ingresando username...");
        loginPage.setUsernameField(username);

        infoLogger.info("Ingresando password...");
        loginPage.setPasswordField(password);
        screenCapture.takeScreen("testCaseLoginSuccess","1.LoginPageScreen.png");

        infoLogger.info("Click en el boton login...");
        loginPage.clickLoginBtn();
        screenCapture.takeScreen("testCaseLoginSuccess","2.ProductPageScreen.png");
    }

    public void loginSuccess(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        LoginPage loginPage = new LoginPage(driver);

        infoLogger.info("Realizando login...");
        loginPage.loginSuccessful();
    }

}
