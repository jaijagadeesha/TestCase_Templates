package demo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase07_Automate_window_handle {

    ChromeDriver driver;

    public TestCase07_Automate_window_handle() {
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


    public void testCase07() {
        System.out.println("Start Test case: testCase07");
         String newURL="";

        // 1.Launch Chrome Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // 2. Enter the URL
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        newURL=driver.getCurrentUrl();
        System.out.println("Current URl " +  newURL );

        //Count number of windows
        int tottalWindows=driver.getWindowHandles().size();
        System.out.println("Total Windows :"+tottalWindows);
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        int totalWindows=driver.getWindowHandles().size();
        System.out.println("Total Windows after click event :"+totalWindows);
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        //driver.switchTo().window(null)
       // driver.switchTo().window(WindowType. WINDOW);
       //driver.switchTo().newWindow(WindowType. WINDOW);
       //driver.switchTo().
       Set<String> allwins= driver.getWindowHandles();
       Iterator<String> it= allwins.iterator();
       String parentURL=it.next();
       String childurl=it.next();
       System.out.println("Parent Windoe"+parentURL );
       System.out.println("child Windoe"+childurl );
        driver.switchTo().window(childurl);   
           newURL=driver.getCurrentUrl();
        System.out.println("Current URl after new window launch  :  " +  newURL );
       
        

        System.out.println("end Test case: testCase07");
    }

    
}
