package co.com.sofka.utils.others;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenCapture {

    private WebDriver driver;

    public ScreenCapture(WebDriver driver){
        this.driver = driver;
    }

    public void takeScreen(String directoryName, String screenName){
        Screenshot screenshot = new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try{
            ImageIO.write(screenshot.getImage(),"PNG",
                    new File("C:\\Users\\luisg\\Desktop\\Retos_Sofka\\Sofka_automation_challenge" +
                            "\\src\\main\\resources\\screenshots\\" + directoryName + "\\" + screenName));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
