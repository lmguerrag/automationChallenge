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

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "btn")
    List<WebElement> productBtnList;

    @FindBy(className = "shopping_cart_link")
    WebElement cartBtn;

    public void clickAddToCartBtn(int index){
        productBtnList.get(index - 1).click();
    }

    public void clickCartBtn(){
        cartBtn.click();
    }

    public void addProductSuccess(){
        clickAddToCartBtn(4);
        clickCartBtn();
    }
}
