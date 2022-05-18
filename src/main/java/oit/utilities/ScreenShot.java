package oit.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public static WebDriver driver;

    public ScreenShot(WebDriver driver) {
        ScreenShot.driver = driver;
    }

    public static String takeScreenShot(String path) throws IOException {
        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        String imageLocation = "./screenshots/" + path;
        FileUtils.copyFile(srcFile, new File(imageLocation));
        return imageLocation;
    }
}
