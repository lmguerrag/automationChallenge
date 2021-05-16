package co.com.sofka.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "btn")
    List<WebElement> productBtnList;

    @FindBy(className = "shopping_cart_link")
    WebElement cartBtn;

    private void logConfigSetUp(){
        PropertyConfigurator.configure("src/main/resources/logConfig/log4j.properties");
    }

    public void clickAddToCartBtn(int index){
        logConfigSetUp();
        infoLogger.info("Click en el boton Add to cart...");
        productBtnList.get(index - 1).click();
    }

    public void clickCartBtn(){
        infoLogger.info("Click en el carrito...");
        cartBtn.click();
    }
}
