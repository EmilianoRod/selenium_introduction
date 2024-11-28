package SSL;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SSLCheck {

    public static void main(String[] args) {

        // Pass SSL ceritication (Insecure site)
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        // Set a proxy server
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddresss:4444");
        options.setCapability("proxy", proxy);

        // Choose the folder where to download the files
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

    }

}
