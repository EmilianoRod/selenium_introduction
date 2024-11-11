package GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class base {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(3000);
        int j = 0;


        // Expected
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

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
