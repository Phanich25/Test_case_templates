package demo;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class SearchAmazon {
    ChromeDriver driver;
    public SearchAmazon()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        //Launch Chrome
        //Navigate to url "www.google.com"
        driver.get("https://www.google.com");
        
        // Enter the text "amazon" in the google searchbar Using Locator "Name" "q" | sendKeys("amazon")
        driver.findElement(By.name("q")).sendKeys("amazon");
        // Click on the Google Search Using Locator "XPath" //input[@value='Google Search'] | click()
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
        Thread.sleep(3000);
        // Get the count of "amazon.in" in the results page. Using Locator "XPath" //*[text()='Amazon.in'] | size() > 0
        System.out.println(driver.findElements(By.xpath("//*[text()='Amazon.in']")).size());
        // Get the count of "amazon.com" in the results page. Using Locator "XPath" //*[text()='Amazon.com'] | size() > 0
        System.out.println(driver.findElements(By.xpath("//*[text()='Amazon.com']")).size());
        System.out.println("end Test case: testCase01");
    }


}
