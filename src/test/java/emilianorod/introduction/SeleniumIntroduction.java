package emilianorod.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumIntroduction {

    public static void main(String[] args) {

        //Invoking the browser
        //Chrome - ChromeDriver -> Methods
        //Firefox - FirefoxDriver -> Methods
        //Safari - SafariDriver -> Methods
        //WebDriver methods + class methods

        //chromedriver -> Chrome browser Selenium Manager
        //step to invoke chrome driver
        WebDriver driver = new ChromeDriver();

        //Safari launch
//        WebDriver driver = new SafariDriver();

        driver.get("https://rahulshettyacademy.com/");
        driver.getTitle();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.close();
//        driver.quit();
    }
}
