package Browser;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscelleanous {

    public static void main(String[] args) throws IOException {

        // Maximize window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Delete all the cookies before start execution
        driver.manage().deleteAllCookies();

        // Delete a specific cookies before start execution
        driver.manage().deleteCookieNamed("asdf");

        //click on any link
        //login page - verify login url
        driver.get("https://www.google.com/");

        // Capture screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("Screenshots/screenshot.png"));




    }

}
