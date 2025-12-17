package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeSuite
    public void setUpSuite(){
        System.out.println("----- NopCommerce Suite Started -----");
    }

    @BeforeMethod
    public void setUpTest(){
        System.out.println("----- Launching Browser -----");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownTest(){
        System.out.println("----- Closing Browser -----");
        if (driver != null){
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownSuite(){
        System.out.println("----- NopCommerce Suite Finished -----");
    }
}
