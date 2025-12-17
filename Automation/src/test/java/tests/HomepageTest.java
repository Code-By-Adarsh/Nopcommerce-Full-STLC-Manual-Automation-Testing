package tests;

import base.BaseTest;
import listeners.ExtentListener;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Homepage;


@Listeners(ExtentListener.class)
public class HomepageTest extends BaseTest {

    @Test(description="Verify homepage loads with UI components.")
    public void test1(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isLogoVisible(),"Homepage did not opened with ui component.");
    }

    @Test(description="Verify homepage load time <3 sec.")
    public void test2(){
        Homepage homepage = new Homepage(driver);
        long startTime = System.currentTimeMillis();
        Assert.assertTrue(homepage.isLogoVisible());
        long finishTime = System.currentTimeMillis();
        long usedTime = finishTime - startTime;
        System.out.println("Start time: "+startTime+" ms");
        System.out.println("Finish time: "+finishTime+" ms");
        System.out.println("Time take to load page: "+usedTime+" ms");
        Assert.assertTrue(usedTime<3000,"Page load time more than 3 sec.");
    }

    @Test(description="Verify visibility of top navigation links.")
    public void test3(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isNavigationLinkVisible(),"Navigation link visibility failed.");
    }

    @Test(description="Verify navigation links redirect correctly.")
    public void test4(){
        //Cloudflare blocked this test due to bot-protection
        if (true){
            throw new SkipException("Test skip because of cloudflare bot-protection.");
        }
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isNavigationLinkWork(),"Navlinks did not redirect correctly.");

    }

    @Test(description="Verify currency dropdown visibility.")
    public void test5(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isCurrencyDropdownVisible(),"Currency dropdown did not visible.");
    }

    @Test(description="Verify currency selection updates prices.")
    public void test6(){
        //Cloudflare blocked this test due to bot-protection
        if (true){
            throw new SkipException("Test skip because of cloudflare bot-protection.");
        }
        Homepage homepage = new Homepage(driver);
        Assert.assertEquals(homepage.currencyPriceCheck(),"€1548.00","Price did not changed by changing the currency.");
    }

    @Test(description="Verify search results for valid keyword.")
    public void test7(){
        //Cloudflare blocked this test due to bot-protection
        if (true){
            throw new SkipException("Test skip because of cloudflare bot-protection.");
        }
        Homepage homepage = new Homepage(driver);
        String Result = homepage.searchFunctionWork("Laptop");
        System.out.println("Search result On Laptop: "+Result);
        Assert.assertTrue(Result.contains("Laptop"),"Search function did not work correctly.");
    }

    @Test(description="Verify product suggestion works.")
    public void test8(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.searchSuggestionWork().contains("Shoes"),"Search suggestion did not work.");
    }

    @Test(description="Verify no results for invalid keyword.")
    public void test9(){
        //Cloudflare blocked this test due to bot-protection
        throw new SkipException("Due to cloudflare bot-protection.");
    }

    @Test(description="Verify no product cards for invalid search.")
    public void test10(){
        //Cloudflare blocked this test due to bot-protection
        throw new SkipException("Due to cloudflare bot-protection.");
    }

    @Test(description="Verify top menu category visibility.")
    public void test11(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isCategoryMenuVisible(),"Category Menu did not visible.");
    }

    @Test(description="Verify category redirects correctly.")
    public void test12(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isCategoryRedirectWork().contains("apparel"),"Category redirect working failed.");
    }

    @Test(description="Verify homepage banner loads.")
    public void test13(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isBannerLoad(),"I-phone banner did not visible.");
    }

    @Test(description="Verify banner auto-slide works.")
    public void test14(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isBannerSLideWorking(),"Banner did not slide correctly.");
        System.out.println("Galaxy S24 banner clearly visible.");
    }

    @Test(description="Verify featured product section visibility.")
    public void test15(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isFeaturedSectionVisible(),"Featured Section visibility failed.");
    }

    @Test(description="Verify featured product redirection works.")
    public void test16(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isFeaturedProductNavigationWorking().contains("computer"));
        System.out.println("Url after click product from featured section: "+driver.getCurrentUrl());
    }

    @Test(description="Verify logo after refresh.")
    public void test17(){
        //Cloudflare may blocked this test due to bot-protection.
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.refreshVisibilityValidation(),"NopCommerce logo did not visible on refresh.");
    }

    @Test(description="Verify no UI misalignment after refresh.")
    public void test18(){
        //Cloudflare blocked this test due to bot-protection.
        throw new SkipException("Due to cloudflare bot-protection.");
    }

    @Test(description="Verify no broken images.")
    public void test19(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.imageBrokenValidation(),"Broken image validation failed.");
        System.out.println("All featured product section images visible.");
    }

    @Test(description="Verify essential UI elements exist.")
    public void test20(){
        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.essentialUIValidation(),"Essential ui components validation failed.");
    }

}