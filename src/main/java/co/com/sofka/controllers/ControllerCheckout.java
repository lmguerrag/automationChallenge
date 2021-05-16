package co.com.sofka.controllers;

import co.com.sofka.pages.CheckoutPage;
import co.com.sofka.pages.LoginPage;
import co.com.sofka.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ControllerCheckout {

    private WebDriver driver;

    public ControllerCheckout(WebDriver driver){
        this.driver = driver;
    }

    public void testCaseSuccessfulPurchase(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.setFirstNameField("luis");
        checkoutPage.setLastNameField("guerra");
        checkoutPage.setPostalField("13000");
        checkoutPage.clickContinueBtn();

        Screenshot screenshot = new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try{
            ImageIO.write(screenshot.getImage(),"PNG",
                    new File("C:\\Users\\luisg\\Desktop\\Retos_Sofka\\Sofka_automation_challenge" +
                            "\\src\\main\\resources\\screenshots\\testSuccessfulPurchase.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
