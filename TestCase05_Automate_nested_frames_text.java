package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase05_Automate_nested_frames_text {

    
    ChromeDriver driver;

    public TestCase05_Automate_nested_frames_text() {
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
public void testCase05() {
        System.out.println("Start Test case: testCase05");

        // 1.Launch Chrome Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // 2. Enter the URL
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //3. Move to top of the frame
        WebElement topFrame= driver.findElement(By.xpath("//frame[@src='/frame_top']"));
        driver.switchTo().frame(topFrame);
        System.out.println(" Fetching the left side value");
        // 3. Move to the left
       WebElement leftFrame= driver.findElement(By.xpath("//frame[@src='/frame_left']"));
         driver.switchTo().frame(leftFrame);
        //driver.switchTo().frame("frame-left");
        System.out.println("********We are switch to the left iframe*******");

        String leftText=driver.findElement(By.xpath("//html/body")).getText();
        System.out.println("Left Frame Text Value= "+leftText);
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();

        /////
    System.out.println("-------- Fetching the center side value--------");
    driver.switchTo().frame(topFrame);
        System.out.println(" Fetching the left side value");
        // 3. Move to the left
       WebElement centerFrame= driver.findElement(By.xpath("//frame[@src='/frame_middle']"));
        driver.switchTo().frame(centerFrame);
        System.out.println("********We are switch to the center iframe*******");
        String centerText=driver.findElement(By.xpath("//html/body")).getText();
        System.out.println("Left Frame Text Value= "+centerText);
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

         System.out.println("----- Fetching the right side value------");
    driver.switchTo().frame(topFrame);
        System.out.println(" Fetching the right side value");
        // 3. Move to the left
       WebElement rightFrame= driver.findElement(By.xpath("//frame[@src='/frame_right']"));
         driver.switchTo().frame(rightFrame);

        //driver.switchTo().frame("frame-left");
        System.out.println("********We are switch to the iframe*******");

        String rightText=driver.findElement(By.xpath("//html/body")).getText();
        System.out.println("Left right Text Value= "+rightText);
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();


         System.out.println("********We are switch  bottom of the iframe*******");

         WebElement bottomFrame= driver.findElement(By.xpath("//frame[@src='/frame_bottom']"));
        driver.switchTo().frame(bottomFrame);
        System.out.println(" Fetching the bottom side value");
        // 3. Move to the left
      

        String bottomOfFrameText=driver.findElement(By.xpath("//html/body")).getText();
        System.out.println("bottom  Frame Text Value= "+bottomOfFrameText);
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        
        System.out.println("end Test case: testCase05");
    }

    
}
