package co.com.sofka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private int numProductsDisplayed = 0;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "btn")
    List<WebElement> productBtnList;

    @FindBy(className = "shopping_cart_link")
    WebElement cartBtn;

    @FindBy(className = "title")
    WebElement titlePage;

    @FindBy(id = "react-burger-menu-btn")
    WebElement optionsMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutBtn;

    @FindBy(css = "img.inventory_item_img")
    List<WebElement> imgProduct;

    public void clickAddToCartBtn(int index){
        productBtnList.get(index - 1).click();
    }

    public void clickCartBtn(){
        cartBtn.click();
    }

    public void clickOptionsMenu(){
        optionsMenu.click();
    }

    public void clickLogoutBtn(){
        logoutBtn.click();
    }

    public int getAmountOfDisplayedProducts(){
        for(WebElement product : imgProduct){
            if(product.isDisplayed()){
                numProductsDisplayed++;
            }
        }
        return numProductsDisplayed;
    }

    public void addProductSuccess(){
        clickAddToCartBtn(4);
        clickCartBtn();
    }

    public String getTitlePage(){
        return titlePage.getText();
    }
}
