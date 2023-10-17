package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase03_Automate_post_on_linkedin {

    ChromeDriver driver;

    public TestCase03_Automate_post_on_linkedin() {
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



    public void testCase03() {
        System.out.println("Start Test case: testCase03");

        // 1.Launch Chrome Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // 2. Enter the URL
        driver.get("https://in.linkedin.com/");

        // 3. Tocount the hyperlinks and count the size
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("jaijagadeesha@gmail.com");
        driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("Amma@1980");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        // Verification Code is asking

        System.out.println("end Test case: testCase03");
    }
    
}
