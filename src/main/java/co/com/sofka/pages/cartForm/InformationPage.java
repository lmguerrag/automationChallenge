package co.com.sofka.pages.cartForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {

    private WebDriver driver;

    public InformationPage(WebDriver driver){
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

    public void setFirstNameField(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void setPostalField(String postal){
        postalField.sendKeys(postal);
    }

    public void clickContinueBtn(){
        continueBtn.click();
    }

}
