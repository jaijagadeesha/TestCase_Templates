package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase06_Automate_imdb_ratings {
    
    ChromeDriver driver;

    public TestCase06_Automate_imdb_ratings() {
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

    public void testCase06() {
        System.out.println("Start Test case: testCase05");

        // 1.Launch Chrome Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // 2. Enter the URL
        driver.get("https://www.imdb.com/chart/top/");

        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        String oldestMovie=driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3")).getText();
        System.out.println("2. Old Rated Movie  "+ oldestMovie);

        //
        Select select=new Select(driver.findElement(By.xpath("//select[@id='sort-by-selector']")));
        select.selectByVisibleText("IMDb rating");
        String highestReatedMovie=driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3")).getText();
        System.out.println("1. Hiigh Rated Movie  "+ highestReatedMovie);

        select.selectByVisibleText("Release date");
        String recentRattedMovie=driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3")).getText();
        
        System.out.println(" 4. Most recent Movie  "+ recentRattedMovie);

         driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        System.out.println(" 3. oldest movie   "+ recentRattedMovie);


        select.selectByVisibleText("Number of ratings");
        String highestRattedMovie=driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3")).getText();
        System.out.println(" 5. Hiigh Rated Movie  "+ highestRattedMovie);

         System.out.println("end Test case: testCase06");
    }


    
}
