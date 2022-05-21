package ExtControllers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class UtilityController {

    public static String takeScreenshot(WebDriver driver, String fileName){
        try {
            TakesScreenshot scrShot = ((TakesScreenshot)driver);
            FileUtils.copyFile(scrShot.getScreenshotAs(OutputType.FILE),
                    new File(System.getProperty("user.dir")+"/screenshots/"+fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  System.getProperty("user.dir")+"/screenshots/"+fileName+".png";
    }
}
