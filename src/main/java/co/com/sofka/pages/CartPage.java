package co.com.sofka.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    private void logConfigSetUp(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
    }

    public void clickCheckoutBtn(){
        logConfigSetUp();
        infoLogger.info("Click en el boton checkout...");
        checkoutBtn.click();
    }
}
