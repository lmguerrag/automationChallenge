package co.com.sofka.controllers;

import co.com.sofka.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ControllerLogin {

    private WebDriver driver;

    public ControllerLogin(WebDriver driver){
        this.driver = driver;
    }

    public void testCaseLoginSuccess(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage.clickLoginBtn();

        Screenshot screenshot = new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try{
            ImageIO.write(screenshot.getImage(),"PNG",
                    new File("C:\\Users\\luisg\\Desktop\\Retos_Sofka\\Sofka_automation_challenge" +
                            "\\src\\main\\resources\\screenshots\\testLoginSuccess.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}
