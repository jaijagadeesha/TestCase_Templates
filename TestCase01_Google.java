package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase01_Google {

    ChromeDriver driver;

    public TestCase01_Google() {
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
    public void testCase01() {
        /*
         * System.out.println("Start Test case: testCase01");
         * driver.get("https://www.google.com");
         * System.out.println("end Test case: testCase02");
         */
        System.out.println("Start Test case: testCase01");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // 1. Launch Chrome browser. ENter url Google.com
        driver.get("https://www.google.com");
        // 2. Enter amazon in search
        driver.findElement(By.name("q")).sendKeys("amazon");
        // 3.
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        // 4. Check amazon.in is displayed

        List<WebElement> allEelemnts = driver.findElements(By.tagName("h3"));
        for (WebElement ele : allEelemnts) {
            String text = ele.getText();
            if (text.equalsIgnoreCase("amazon.in")) {
                System.out.println(" The Amazon.in Link Found");
                break;
            }
        }
        // 5. Check amazon.com is displayed

        List<WebElement> allEelemnt = driver.findElements(By.tagName("h3"));
        for (WebElement ele : allEelemnt) {
            String text = ele.getText();
            if (text.equalsIgnoreCase("amazon.com")) {
                System.out.println(" Amazon.com link Found");
                break;
            }
        }

        System.out.println("end Test case: testCase01");
    }

    
}
