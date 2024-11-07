package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options =  driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));

        for (WebElement option : options) {
            if(option.getText().equals("India")){
                option.click();
                break;
            }
        }

    }




}
