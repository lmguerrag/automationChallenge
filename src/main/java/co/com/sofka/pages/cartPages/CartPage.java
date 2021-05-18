package co.com.sofka.pages.cartPages;

import co.com.sofka.pages.LoginPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(className = "inventory_item_name")
    WebElement productName;

    public void clickCheckoutBtn(){
        checkoutBtn.click();
    }

    public String getProductName(){
        return productName.getText();
    }
}
