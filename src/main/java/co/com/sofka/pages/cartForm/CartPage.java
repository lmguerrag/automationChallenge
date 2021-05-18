package co.com.sofka.pages.cartForm;

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

    @FindBy(css = "button[id*='remove']")
    WebElement removeBtn;

    @FindBy(className = "removed_cart_item")
    WebElement productRemoved;

    public void clickCheckoutBtn(){
        checkoutBtn.click();
    }

    public void clickRemoveBtn(){
        removeBtn.click();
    }

    public String getProductName(){
        return productName.getText();
    }

    public String getProductRemoveAttribute(){
        return productRemoved.getAttribute("class");
    }
}
