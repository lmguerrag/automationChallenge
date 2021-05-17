package co.com.sofka.controllers;

import co.com.sofka.pages.LoginPage;
import co.com.sofka.pages.cartPages.CartPage;
import co.com.sofka.pages.cartPages.CompletePage;
import co.com.sofka.pages.cartPages.InformationPage;
import co.com.sofka.pages.cartPages.OverviewPage;
import co.com.sofka.utils.others.ScreenCapture;
import com.github.javafaker.Faker;
import org.apache.hc.core5.util.Asserts;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerCart {

    private WebDriver driver;
    private InformationPage informationPage;
    private CartPage cartPage;
    private CompletePage completePage;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public ControllerCart(WebDriver driver){
        this.driver = driver;
    }

    public void testCaseSuccessfulPurchase(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        ScreenCapture screenCapture = new ScreenCapture(driver);
        informationPage = new InformationPage(driver);
        Faker faker = new Faker();

        cartPage = new CartPage(driver);
        infoLogger.info("Click en el boton checkout...");
        cartPage.clickCheckoutBtn();

        infoLogger.info("Ingresando firstName...");
        informationPage.setFirstNameField(faker.name().firstName());

        infoLogger.info("Ingresando lasttName...");
        informationPage.setLastNameField(faker.name().lastName());

        infoLogger.info("Ingresando postalCode...");
        informationPage.setPostalField(faker.address().zipCode());
        screenCapture.takeScreen("testCaseSuccessfulPurchase","1.InformationPageScreen.png");

        infoLogger.info("Click en el boton continue...");
        informationPage.clickContinueBtn();
        screenCapture.takeScreen("testCaseSuccessfulPurchase","2.OverviewPageScreen.png");

        OverviewPage overviewPage = new OverviewPage(driver);
        infoLogger.info("Click en el boton Finish...");
        overviewPage.clickFinishBtn();
        screenCapture.takeScreen("testCaseSuccessfulPurchase","3.CompletePageScreen.png");

    }

    public void TestCaseSuccessfulPurchaseResult(){
        completePage = new CompletePage(driver);
        completePage.getCompleteMessage();

    }

}
