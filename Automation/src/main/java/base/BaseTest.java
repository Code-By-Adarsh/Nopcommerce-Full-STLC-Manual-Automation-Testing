package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setUpSuite(){
        System.out.println("----- NopCommerce Suite Started -----");
    }

    @BeforeMethod
    public void setUpTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demo.nopcommerce.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownTest(){
        if (driver != null){
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownSuite(){
        System.out.println("----- NopCommerce Suite Finished -----");
    }
}
