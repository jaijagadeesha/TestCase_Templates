package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase02_Automate_count_hyperlinks {

     ChromeDriver driver;

    public TestCase02_Automate_count_hyperlinks() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase02() {
        System.out.println("Start Test case: testCase02");

        // 1.Launch Chrome Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // 2. Enter the URL
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        // 3. Tocount the hyperlinks and count the size
        List<WebElement> alllinks = driver.findElements(By.tagName("a"));
        System.out.println(" Total hyperlnks present : " + alllinks.size());

        System.out.println("end Test case: testCase02");
    }
    
}
