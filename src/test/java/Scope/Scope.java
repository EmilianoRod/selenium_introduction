package Scope;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {

        // 1. Give me the count of links on the page.


        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        // 2. Count of Footer section
        // Limiting WebDriver scope
        WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']")); // Limiting WebDriver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        // 3.
        WebElement columnDriver = footerDriver.findElement(By.xpath("//body/div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());


        // 4. Click on each link in the column and check if the pages are opening -
        Thread.sleep(2000);
        for(int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++){
            Thread.sleep(2000);
            String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }

        // opens all the tabs
        Set<String> abc = driver.getWindowHandles(); //4
        Iterator<String> iterator = abc.iterator();

        while(iterator.hasNext()){
            Thread.sleep(2000);
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }


    }
}
