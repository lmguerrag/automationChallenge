package co.com.sofka.pages.cartForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage {

    private WebDriver driver;

    public CompletePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "complete-header")
    WebElement completeMessage;

    public String getCompleteMessage(){
        return completeMessage.getText();
    }
}
