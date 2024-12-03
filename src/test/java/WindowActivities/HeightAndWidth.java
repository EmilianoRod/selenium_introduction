package WindowActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeightAndWidth {

    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameInput = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));

        // Get Height & Width
        System.out.println(nameInput.getRect().getDimension().getHeight());
        System.out.println(nameInput.getRect().getDimension().getWidth());

    }
}
