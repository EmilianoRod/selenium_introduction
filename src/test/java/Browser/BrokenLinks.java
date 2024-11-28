package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();

        // broken URL

        // Step 1 - Is to get all urls tied up to the links using Selenium
        // Java methods will call URL's and gets you the status code
        // If status code > 400 then that url is not working -> link which tied to url is broken

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.xpath("(//li[@class='gf-li'])//a"));
        SoftAssert softAssert = new SoftAssert();

        for(WebElement link : links){
            String url = link.getAttribute("href");

            HttpURLConnection urlConnection = (HttpURLConnection)new URL(url).openConnection();
            urlConnection.setRequestMethod("HEAD");
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            System.out.println(responseCode);
            softAssert.assertTrue(responseCode <= 400, "The link with text: " + link.getText() + " is broken with code: " + responseCode);
        }
        softAssert.assertAll();



    }
}
