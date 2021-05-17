package co.com.sofka.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    //private static Logger infoLogger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public void setUsernameField(String username){
        usernameField.sendKeys(username);
    }

    public void setPasswordField(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void loginSuccessful(){
        try {
            setUsernameField("standard_user");
            setPasswordField("secret_sauce");
            clickLoginBtn();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
