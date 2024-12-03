package WindowActivities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow_TakePartialScreenshot {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");



/*        // Open new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // Switch Selenium focus to new window
        Set<String> handlesWindowsIds = driver.getWindowHandles();
        Iterator<String> iterator = handlesWindowsIds.iterator();
        String parentWindowId = iterator.next();
        String childWindowId = iterator.next();
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");

        String courseName = driver.findElements(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p')]")).get(3).getText();

        // Switch Selenium focus to old (parent) window
        driver.switchTo().window(parentWindowId);

        // Send course name into name box
        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys(courseName);
        Thread.sleep(2000);*/



        // Open new Window
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Switch Selenium focus to new window
        Set<String> handlesWindowsIds = driver.getWindowHandles();
        Iterator<String> iterator = handlesWindowsIds.iterator();
        String parentWindowId = iterator.next();
        String childWindowId = iterator.next();
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");

        Thread.sleep(5000);
        String courseName = driver.findElements(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p')]")).get(3).getText();

        // Switch Selenium focus to old (parent) window
        driver.switchTo().window(parentWindowId);

        // Send course name into name box
        Thread.sleep(1000);
        WebElement nameInput =  driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
        nameInput.sendKeys(courseName);
        Thread.sleep(1000);

        // Get Partial Screenshot - name text input
        File file =  nameInput.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("Screenshots/logo.png"));


    }

}
