package co.com.sofka.controllers;

import co.com.sofka.dto.ClientDTO;
import co.com.sofka.pages.LoginPage;
import co.com.sofka.pages.cartForm.CartPage;
import co.com.sofka.pages.cartForm.CompletePage;
import co.com.sofka.pages.cartForm.InformationPage;
import co.com.sofka.pages.cartForm.OverviewPage;
import co.com.sofka.utils.database.Mapper;
import co.com.sofka.utils.others.ScreenCapture;
import com.github.javafaker.Faker;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ControllerCart {

    private WebDriver driver;
    private InformationPage informationPage;
    private CartPage cartPage;
    private CompletePage completePage;
    private String firstName;
    private String lastName;
    private String postalCode;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public ControllerCart(WebDriver driver){
        this.driver = driver;
    }

    public void testCaseSuccessfulPurchase(boolean data, String directoryScreen){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        ScreenCapture screenCapture = new ScreenCapture(driver);
        informationPage = new InformationPage(driver);

        cartPage = new CartPage(driver);
        infoLogger.info("Click en el boton checkout...");
        cartPage.clickCheckoutBtn();

        if(data){
            infoLogger.info("Obteniendo datos de la base de datos...");
            getInfoFromDatabase();
        }
        else{
            infoLogger.info("Generando datos con javafaker...");
            getInfoFromFakerData();
        }

        infoLogger.info("Ingresando firstName...");
        informationPage.setFirstNameField(firstName);

        infoLogger.info("Ingresando lasttName...");
        informationPage.setLastNameField(lastName);

        infoLogger.info("Ingresando postalCode...");
        informationPage.setPostalField(postalCode);
        screenCapture.takeScreen("testCasePurchase\\" + directoryScreen,"1.InformationPageScreen.png");

        infoLogger.info("Click en el boton continue...");
        informationPage.clickContinueBtn();
        screenCapture.takeScreen("testCasePurchase\\" + directoryScreen,"2.OverviewPageScreen.png");

        OverviewPage overviewPage = new OverviewPage(driver);
        infoLogger.info("Click en el boton Finish...");
        overviewPage.clickFinishBtn();
        screenCapture.takeScreen("testCasePurchase\\" + directoryScreen,"3.CompletePageScreen.png");
    }

    public void testCaseRemoveProductFromTheCart(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
        ScreenCapture screenCapture = new ScreenCapture(driver);
        CartPage cartPage = new CartPage(driver);

        screenCapture.takeScreen("testCaseRemove","1.CartPageScreenBefore.png");
        infoLogger.info("Click en el boton remove...");
        cartPage.clickRemoveBtn();
        screenCapture.takeScreen("testCaseRemove","2.CartPageScreenAfter.png");
    }

    public void validateTestCaseRemove(){
        infoLogger.info("Comprobando resultados...");
        CartPage cartPage = new CartPage(driver);
        assertEquals("removed_cart_item", cartPage.getProductRemoveAttribute());
    }

    private void getInfoFromFakerData(){
        Faker faker = new Faker();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        postalCode = faker.address().zipCode();
    }

    private void getInfoFromDatabase(){
        Mapper mapper = new Mapper();

        List<ClientDTO> clientDTOS = mapper.createDTO();
        firstName = clientDTOS.get(0).getFirstName();
        lastName = clientDTOS.get(0).getLastName();
        postalCode = clientDTOS.get(0).getPostalCode();
    }

    public void validateTestCaseSuccessfulPurchase(){
        infoLogger.info("Comprobando resultados...");
        completePage = new CompletePage(driver);
        assertEquals("THANK YOU FOR YOUR ORDER",completePage.getCompleteMessage());
    }

    /**
     * Al completar una compra sin productos en el carro, no deberia mostrar el mensaje "THANK YOU FOR YOUR ORDER"
     * por lo que se utiliza este assert para verificar que el mensaje no se, pero se presenta,
     * aceptando compras vacias, lo cual deberia ser corregido.
     */
    public void validateTestCasePurchaseWithoutProducts(){
        infoLogger.info("Comprobando resultados...");
        completePage = new CompletePage(driver);
        assertFalse(completePage.getCompleteMessage().contains("THANK YOU FOR YOUR ORDER"));
    }

}
