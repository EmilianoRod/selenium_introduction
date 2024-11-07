package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropdown = driver.findElement(By.xpath("(//select[@id='ctl00_mainContent_DropDownListCurrency'])[1]"));

        // dropdown with select tag
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3); // This is one way to select an option from a dropdown
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());



    }
}
