package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot {
	
	public static String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        String path = "screenshots/" + screenshotName;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);
        dest.getParentFile().mkdirs();
        try {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
