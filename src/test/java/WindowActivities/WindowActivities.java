package WindowActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();
        driver.get("http://google.com"); // It waits until all the components from the page are fully loaded
        driver.navigate().to("https://rahulshettyacademy.com/"); // It does NOT wait for the page to be fully loaded
        driver.navigate().back();
        driver.navigate().forward();


    }
}
