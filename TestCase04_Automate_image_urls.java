package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase04_Automate_image_urls {

    ChromeDriver driver;

    public TestCase04_Automate_image_urls() {
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
public void testCase04() {
        System.out.println("Start Test case: testCase04");

        // 1.Launch Chrome Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // 2. Enter the URL
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        // 3. Find the image URLs for all the Recommended Movies
        List<WebElement> alllinks = driver
                .findElements(By.xpath("//div[@class='style__RelativeContainer-sc-lnhrs7-0 jhuTSq']//div/a"));
        if (alllinks.size() > 0) {
            System.out.println("  URLS are displayed");
        }

        // Print all URL's
        System.out.println("Printing the URL");
        List<WebElement> urllist = driver
                .findElements(By.xpath("//div[@class='style__StyledText-sc-7o7nez-0 eJQlCo']"));
        for (WebElement ele : urllist) {
            System.out.println(ele.getText());
        }
        System.out.println("****************");
        // Print Name & Language of the 2nd item in the Premiere list
        WebElement parentXpath = driver
                .findElement(By.xpath("(//div[@class='style__RelativeContainer-sc-lnhrs7-0 jhuTSq']//div/a)[2]"));
        // name
        String nameOfTheMovie = parentXpath.findElement(By.xpath("//div[@class='style__StyledText-sc-7o7nez-0 eJQlCo']"))
                .getText();
        System.out.println(" Movie Name" + nameOfTheMovie);

        // value
        String valueOfTheMovie = parentXpath.findElement(By.xpath("//div[@class='style__StyledText-sc-7o7nez-0 fIlqSN']"))
                .getText();
        System.out.println(" Movie Name" + valueOfTheMovie);

        System.out.println("end Test case: testCase04");
    }


    
}
