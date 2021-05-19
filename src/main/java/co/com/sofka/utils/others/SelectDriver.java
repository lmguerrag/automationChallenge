package co.com.sofka.utils.others;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {

    private WebDriver driver;

    public SelectDriver(WebDriver driver) { this.driver = driver; }

    public WebDriver selectBrowser(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        else {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    }
}
