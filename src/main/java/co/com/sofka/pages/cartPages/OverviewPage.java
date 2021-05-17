package co.com.sofka.pages.cartPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {

    private WebDriver driver;

    public OverviewPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    WebElement finishBtn;

    public void clickFinishBtn(){
        finishBtn.click();
    }
}
