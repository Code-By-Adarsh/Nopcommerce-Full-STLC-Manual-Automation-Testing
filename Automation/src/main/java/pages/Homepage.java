package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Homepage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nopCommerceLogo = By.cssSelector("img[alt='nopCommerce demo store']");
    private By registerNav = By.className("ico-register");
    private By loginNav = By.className("ico-login");
    private By wishlistNav = By.className("wishlist-label");
    private By cartNav = By.className("cart-label");
    private By currencyNav = By.id("customerCurrency");
    private By appleMacPriceInDollar = By.xpath("//span[normalize-space()='$1,800.00']");
    private By euroCurrencyValue = By.xpath("//option[normalize-space()='Euro']");
    private By appleMacPriceInEuro = By.xpath("//span[normalize-space()='€1548.00']");
    private By searchBar = By.id("small-searchterms");
    private By searchResult = By.xpath("//a[text()='Asus Laptop']");
    private By searchSuggestion = By.xpath("//li//a//span[contains(normalize-space(),'Shoes')]");
    private By categoriesMenu = By.id("menu-1");
    private By computerMenu = By.xpath("//a[normalize-space()='Computers']");
    private By electronicsMenu = By.xpath("//a[normalize-space()='Electronics']");
    private By apparelMenu = By.xpath("//a[normalize-space()='Apparel']");
    private By digitalMenu = By.xpath("//a[normalize-space()='Digital downloads']");
    private By booksMenu = By.xpath("//a[normalize-space()='Books']");
    private By jewelryMenu = By.xpath("//a[normalize-space()='Jewelry']");
    private By giftMenu = By.xpath("//a[normalize-space()='Gift Cards']");
    private By iphoneBanner = By.cssSelector("div[aria-label='1 / 2']");
    private By s24Banner = By.cssSelector("div[aria-label='2 / 2']");
    private By featuredSection = By.xpath("//h2[text()='Featured products']");
    private By featuredProducts = By.className("product-item");
    private By featuredFirstProduct = By.xpath("//a[text()='Build your own computer']");
    private By electronicsImage = By.cssSelector("img[alt='Picture for category Electronics']");
    private By apparelImage = By.cssSelector("img[alt='Picture for category Apparel']");
    private By digitalCardsImage = By.cssSelector("img[alt='Picture for category Digital downloads']");
    private By computerImage = By.cssSelector("img[alt='Picture of Build your own computer']");
    private By appleMacProImage = By.cssSelector("img[alt='Picture of Apple MacBook Pro']");
    private By htcImage = By.cssSelector("img[alt='Picture of HTC smartphone']");
    private By virtualGiftCardImage = By.cssSelector("img[alt='Picture of $25 Virtual Gift Card']");

    public Homepage(WebDriver driver){
        this.driver = driver;
        driver.get("https://demo.nopcommerce.com/");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLogoVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nopCommerceLogo)).isDisplayed();
    }

    public boolean isNavigationLinkVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerNav));
        if (driver.findElement(registerNav).isDisplayed() && driver.findElement(loginNav).isDisplayed() && driver.findElement(wishlistNav).isDisplayed() && driver.findElement(cartNav).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public boolean isNavigationLinkWork(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerNav));
        driver.findElement(registerNav).click();
        wait.until(ExpectedConditions.urlContains("register"));
        System.out.println("Register Page Url: "+driver.getCurrentUrl());
        driver.findElement(loginNav).click();
        wait.until(ExpectedConditions.urlContains("login"));
        System.out.println("Login Page Url: "+driver.getCurrentUrl());
        driver.findElement(wishlistNav).click();
        wait.until(ExpectedConditions.urlContains("wishlist"));
        System.out.println("Wishlist Page Url: "+driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartNav));
        driver.findElement(cartNav).click();
        wait.until(ExpectedConditions.urlContains("cart"));
        System.out.println("Cart Page Url: "+driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("cart")){
            return true;
        }else {
            return false;
        }
    }

    public boolean isCurrencyDropdownVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(currencyNav)).isDisplayed();
    }

    public String currencyPriceCheck(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(appleMacPriceInDollar));
        System.out.println("Apple Mac Pro Price in $: "+driver.findElement(appleMacPriceInDollar).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(currencyNav));
        driver.findElement(currencyNav).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(euroCurrencyValue));
        driver.findElement(euroCurrencyValue).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(appleMacPriceInEuro));
        System.out.println("Apple Mac Pro Price in Euro: "+driver.findElement(appleMacPriceInEuro).getText());
        return driver.findElement(appleMacPriceInEuro).getText();
    }

    public String searchFunctionWork(String Product){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).sendKeys(Product);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
        return driver.findElement(searchResult).getText();
    }

    public String searchSuggestionWork(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        WebElement el = driver.findElement(searchBar);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).sendKeys("Shoes");
        driver.findElement(searchBar).click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestion));
        return driver.findElement(searchSuggestion).getText();
    }

    public boolean isCategoryMenuVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesMenu));
        WebElement el = driver.findElement(categoriesMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(computerMenu));
        if (driver.findElement(computerMenu).isDisplayed() && driver.findElement(electronicsMenu).isDisplayed() && driver.findElement(apparelMenu).isDisplayed() && driver.findElement(digitalMenu).isDisplayed() && driver.findElement(giftMenu).isDisplayed() && driver.findElement(booksMenu).isDisplayed() && driver.findElement(jewelryMenu).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public String isCategoryRedirectWork(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesMenu));
        WebElement el = driver.findElement(categoriesMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(apparelMenu));
        driver.findElement(apparelMenu).click();
        wait.until(ExpectedConditions.urlContains("apparel"));
        System.out.println("Url after clicking Apparel category: "+driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public boolean isBannerLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(iphoneBanner));
        WebElement el = driver.findElement(iphoneBanner);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(iphoneBanner)).isDisplayed();
    }

    public boolean isBannerSLideWorking(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(iphoneBanner));
        WebElement el = driver.findElement(iphoneBanner);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.visibilityOfElementLocated(iphoneBanner));
        System.out.println("I-phone banner clearly visible.");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(s24Banner)).isDisplayed();
    }

    public boolean isFeaturedSectionVisible(){
        WebElement el = driver.findElement(featuredSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.visibilityOfElementLocated(featuredSection));
        if (driver.findElement(featuredSection).isDisplayed() && driver.findElement(featuredProducts).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public String isFeaturedProductNavigationWorking(){
        WebElement el = driver.findElement(featuredSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.visibilityOfElementLocated(featuredSection));
        wait.until(ExpectedConditions.elementToBeClickable(featuredFirstProduct)).click();
        wait.until(ExpectedConditions.urlContains("computer"));
        return driver.getCurrentUrl();
    }

    public boolean refreshVisibilityValidation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nopCommerceLogo));
        System.out.println("Main logo visible before: "+"Yes");
        driver.navigate().refresh();
        wait.until(ExpectedConditions.urlContains("demo"));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nopCommerceLogo)).isDisplayed();
    }

    public boolean imageBrokenValidation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(iphoneBanner));
        WebElement el = driver.findElement(iphoneBanner);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.visibilityOfElementLocated(iphoneBanner));
        System.out.println("Iphone banner visible perfectly.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(s24Banner));
        System.out.println("Galaxy s24 banner visible perfectly.");
        WebElement el1 = driver.findElement(electronicsImage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(electronicsImage));
        if (driver.findElement(electronicsImage).isDisplayed() && driver.findElement(apparelImage).isDisplayed() && driver.findElement(digitalCardsImage).isDisplayed()){
            System.out.println("Categories Section all images perfectly visible.");
        }
        WebElement el2 = driver.findElement(computerImage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(computerImage));
        if (driver.findElement(computerImage).isDisplayed() && driver.findElement(appleMacProImage).isDisplayed() && driver.findElement(htcImage).isDisplayed() && driver.findElement(virtualGiftCardImage).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public boolean essentialUIValidation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nopCommerceLogo));
        if (driver.findElement(nopCommerceLogo).isDisplayed() && driver.findElement(cartNav).isDisplayed() && driver.findElement(searchBar).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
}
