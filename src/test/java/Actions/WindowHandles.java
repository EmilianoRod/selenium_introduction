package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        Set<String> windows = driver.getWindowHandles(); // [parentid, childid, subchildId]
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);

        String email = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim()
                .split(" ")[0].trim();
        driver.switchTo().window(parentId);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);



    }
}
