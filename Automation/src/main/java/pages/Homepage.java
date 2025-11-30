package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
    private WebDriver driver;
    private WebDriverWait wait;

    public By nopCommerceLogo = By.cssSelector("img[alt='nopCommerce demo store']");
    public By registerNav = By.linkText("Register");
    public By loginNav = By.linkText("Log in");
    public By wishlistNav = By.className("wishlist-label");
    public By cartNav = By.className("cart-label");

    public Homepage(WebDriver driver,WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
}
