package co.com.sofka.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class CheckoutPage {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalField;

    @FindBy(id = "continue")
    WebElement continueBtn;

    private void logConfigSetUp(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
    }

    public void setFirstNameField(String firstName){
        logConfigSetUp();
        infoLogger.info("Ingresando firstName...");
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName){
        infoLogger.info("Ingresando lasttName...");
        lastNameField.sendKeys(lastName);
    }

    public void setPostalField(String postal){
        infoLogger.info("Ingresando postalCode...");
        postalField.sendKeys(postal);
    }

    public void clickContinueBtn(){
        infoLogger.info("Click en el boton continue...");
        continueBtn.click();
    }

}
