package Checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//TestNG is one of the testing frameworks


public class Checkboxes {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        //radio button
//        System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).isEnabled());
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
        if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1")){
            System.out.println("it's enabled");
            Assert.assertTrue(true);
        }else{
            System.out.println("it's disabled");
            Assert.assertTrue(false);
        }






        // Count the number of checkboxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());


        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
    /*
        int i = 1;
        while(i < 5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
    */
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

    }
}
