package utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class screenshotUtil {

    public static String captureScreenshot(WebDriver driver,String testName){
        String screenshotDir = System.getProperty("user.dir")+"\\src\\main\\reports\\extent-report\\screenshots\\";

        new File(screenshotDir).mkdirs();

        String screenshotPath = screenshotDir + testName + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotPath);

        try{
            Files.copy(src.toPath(),dest.toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
