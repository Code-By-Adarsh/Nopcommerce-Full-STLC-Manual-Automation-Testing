package tests;

import base.BaseTest;
import listeners.BaseListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Homepage;

@Listeners(BaseListener.class)
public class HomepageTest extends BaseTest {
    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void test1(){
        Homepage homepage = new Homepage(driver,wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.nopCommerceLogo));
        Assert.assertTrue(driver.findElement(homepage.nopCommerceLogo).isDisplayed(),"Homepage did not opened with ui component.");
    }

    @Test
    public void test2(){

    }

    @Test
    public void test3(){
        Homepage homepage = new Homepage(driver,wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.registerNav));
        softAssert.assertTrue(driver.findElement(homepage.registerNav).isDisplayed(),"Register navigation link did not visible.");
        softAssert.assertTrue(driver.findElement(homepage.loginNav).isDisplayed(),"Login navigation link did not visible.");
        softAssert.assertTrue(driver.findElement(homepage.wishlistNav).isDisplayed(),"Wishlist navigation link did not visible.");
        softAssert.assertTrue(driver.findElement(homepage.cartNav).isDisplayed(),"Cart navigation link did not visible.");
        softAssert.assertAll();
    }
}