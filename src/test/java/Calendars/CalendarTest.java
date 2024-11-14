package Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalendarTest {

    public static void main(String[] args) throws InterruptedException {

        String monthNumber = "6";
        String day = "15";
        String year = "2027";
        String[] expectedList = {monthNumber, day, year};

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();

        driver.findElement(By.xpath("//button[normalize-space()='" + year +"']")).click();
        driver.findElements(By.xpath("//div[@class='react-calendar__viewContainer']//button")).get(Integer.parseInt(monthNumber) - 1).click();
        driver.findElement(By.xpath("//div[@class='react-calendar__month-view__days']/button//abbr[text()='" + day +"']")).click();

        Thread.sleep(2000);
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i = 0; i < actualList.size(); i++){
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }
        driver.close();


    }
}
