package Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

    public static void main(String[] args) {

        String text = "Emiliano";

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();


        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

    }
}
