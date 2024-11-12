package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        Actions a = new Actions(driver);
        WebElement moveToMoveTo = driver.findElement(By.xpath("//a[@title='Mi eBay']"));


        a.moveToElement(driver.findElement(By.xpath("//input[@id='gh-ac']")))
                .click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        Thread.sleep(3000);


        // Moves to Specific element
        a.moveToElement(moveToMoveTo).contextClick().build().perform();
        Thread.sleep(2000);


    }
}
