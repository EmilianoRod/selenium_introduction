package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());


        WebElement dateOfBirthLabel = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
        // Exceptional because of flex property
        driver.findElement(with(By.tagName("input")).below(dateOfBirthLabel)).click();

        // Check checkbox based upon their text in the left
        WebElement iceCreamLabel = driver.findElement(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        WebElement radioButton = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());


        Thread.sleep(2000);


    }


}
