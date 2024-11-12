package GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ExplicitWait {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(3000);
        // Expected
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        addItems(driver, itemsNeeded);

        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']")));
        driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        // Explicit Wait
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

    }


    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int j = 0;
        for(int i = 0; i < products.size(); i++){
            // format it to get actual vegetable name
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            // check whether name you extracted is present in arrayList or not
            // convert array into arrayList for easy search
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedName)){
                j++;
                // Click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j == itemsNeeded.length){
                    break;
                }
            }

        }
    }
}
