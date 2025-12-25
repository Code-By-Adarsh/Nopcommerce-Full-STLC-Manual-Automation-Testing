package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import java.time.Duration;
import java.util.List;

public class Register {
    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;

    private By genderField = By.id("gender");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By companyField = By.id("Company");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By logo = By.cssSelector("img[alt='nopCommerce demo store']");
    private By searchButton = By.xpath("//button[text()='Search']");
    private By categoryButton = By.xpath("//div[text()='Categories']");
    private By heading = By.xpath("//h1[text()='Register']");
    private By registerButton = By.id("register-button");
    private By result = By.className("result");
    private By genderMale = By.id("gender-male");
    private By firstNameError = By.id("FirstName-error");
    private By lastNameError = By.id("LastName-error");
    private By emailError = By.id("Email-error");
    private By confirmPasswordError = By.id("ConfirmPassword-error");
    private By duplicateEmailError = By.xpath("//li[text()='The specified email already exists']");


    public Register(WebDriver driver){
        this.driver = driver;
        driver.get("https://demo.nopcommerce.com/register");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.softAssert = new SoftAssert();
    }

    public boolean verifyPageLoad(){
        By[] stones = {genderField, firstNameField, lastNameField, emailField, companyField, passwordField, confirmPasswordField};
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(genderField));
        boolean flag = false;
        for (By stone:stones){
            if (driver.findElement(stone).isDisplayed() && stone == stones[stones.length-1]){
                flag = true;
            }
            if (!(driver.findElement(stone).isDisplayed())){
                System.out.println(stone+" not visible");
                flag = false;
                break;
            }
        }return flag;
    }

    public boolean verifyPageLoad2(){
        By[] stones = {logo,searchButton,categoryButton,heading,registerButton};
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logo));
        boolean flag = false;
        for (By stone:stones){
            if (driver.findElement(stone).isDisplayed() && stone == stones[stones.length-1]){
                flag = true;
            }
            if (!(driver.findElement(stone).isDisplayed())){
                System.out.println(stone+" not visible");
                flag = false;
                break;
            }
        }return flag;
    }

    public String verifyValidLogin(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstNameField));
        driver.findElement(firstNameField).sendKeys(value+" ");
        driver.findElement(lastNameField).sendKeys(value+" ");
        driver.findElement(emailField).sendKeys(value+"@gmail.com");
        driver.findElement(passwordField).sendKeys(value+" ");
        driver.findElement(confirmPasswordField).sendKeys(value+" ");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        wait.until(ExpectedConditions.urlContains("result"));
        return driver.getCurrentUrl();
    }

    public String verifyRegisteredMessage(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstNameField));
        driver.findElement(firstNameField).sendKeys(value+" ");
        driver.findElement(lastNameField).sendKeys(value+" ");
        driver.findElement(emailField).sendKeys(value+"@gmail.com");
        driver.findElement(passwordField).sendKeys(value+" ");
        driver.findElement(confirmPasswordField).sendKeys(value+" ");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        wait.until(ExpectedConditions.urlContains("result"));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(result)).getText();
    }

    public boolean verifyValidationForEmptyMandatoryField(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.elementToBeClickable(genderMale)).click();
        driver.findElement(companyField).sendKeys(value+" ");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        By[] stones = {firstNameError,lastNameError,emailError,confirmPasswordError};
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameError));
        boolean flag = false;
        for (By stone:stones){
            if (driver.findElement(stone).isDisplayed() && (stone == stones[stones.length - 1])){
                flag = true;
            }if (!(driver.findElement(stone).isDisplayed())){
                System.out.println(stone+" not visible");
                flag = false;
                break;
            }
        }return flag;
    }

    public boolean verifyRedBorderInvalidMandatoryFields(){
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        By[] stones = {firstNameError,lastNameError,emailError,confirmPasswordError};
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameError));
        boolean flag = false;
        for (By stone:stones){
            if (driver.findElement(stone).isDisplayed() && (stone == stones[stones.length - 1])){
                flag = true;
            }if (!(driver.findElement(stone).isDisplayed())){
                System.out.println(stone+" not visible");
                flag = false;
                break;
            }
        }return flag;
    }

    public boolean verifyInvalidEmailFormat(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(value+"");
        driver.findElement(lastNameField).sendKeys(value+"");
        driver.findElement(emailField).sendKeys("abc@");
        System.out.println("Invalid Email-id: abc@");
        driver.findElement(passwordField).sendKeys(value+"");
        driver.findElement(confirmPasswordField).sendKeys(value+"");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        System.out.println("Error message: "+wait.until(ExpectedConditions.visibilityOfElementLocated(emailError)).getText());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailError)).isDisplayed();
    }

    public boolean verifySpaceRejectEmailField(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(value+"");
        driver.findElement(lastNameField).sendKeys(value+"");
        driver.findElement(emailField).sendKeys("test@ gmail.com");
        System.out.println("Invalid Email-id: test@ gmail.com");
        driver.findElement(passwordField).sendKeys(value+"");
        driver.findElement(confirmPasswordField).sendKeys(value+"");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        System.out.println("Error message: "+wait.until(ExpectedConditions.visibilityOfElementLocated(emailError)).getText());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailError)).isDisplayed();
    }

    public boolean verifyDuplicateEmailRegistration(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(value+"");
        System.out.println("First time registration on email:");
        System.out.println("First Name: "+value);
        driver.findElement(lastNameField).sendKeys(value+"");
        System.out.println("Last Name: "+value);
        driver.findElement(emailField).sendKeys(value+"@gamil.com");
        System.out.println("Email-id: "+value+"@gmail.com");
        driver.findElement(passwordField).sendKeys(value+"");
        driver.findElement(confirmPasswordField).sendKeys(value+"");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        wait.until(ExpectedConditions.urlContains("result"));
        System.out.println("Register successful message: "+driver.findElement(result).getText());
        driver.navigate().to("https://demo.nopcommerce.com/register");
        Long value1 = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(value1+"");
        System.out.println("\nSecond time registration on same email:");
        System.out.println("First Name: "+value1);
        driver.findElement(lastNameField).sendKeys(value1+"");
        System.out.println("Last Name: "+value1);
        driver.findElement(emailField).sendKeys(value+"@gamil.com");
        System.out.println("Email-id: "+value+"@gmail.com");
        driver.findElement(passwordField).sendKeys(value1+"");
        driver.findElement(confirmPasswordField).sendKeys(value1+"");
        WebElement el1 = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el1);
        wait.until(ExpectedConditions.elementToBeClickable(el1)).click();
        System.out.println("Duplicate email error message: "+wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateEmailError)).getText());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateEmailError)).isDisplayed();
    }

    public boolean verifySystemBlockedDuplicateEmailRegistration(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(value+"");
        System.out.println("First Name: "+value);
        driver.findElement(lastNameField).sendKeys(value+"");
        System.out.println("Last Name: "+value);
        driver.findElement(emailField).sendKeys("test@gmail.com");
        System.out.println("Registered email-id: test@gmail.com");
        driver.findElement(passwordField).sendKeys(value+"");
        System.out.println("Password: **********");
        driver.findElement(confirmPasswordField).sendKeys(value+"");
        System.out.println("Confirm Password: **********");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        System.out.println("Duplicate email error message: "+wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateEmailError)).getText());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateEmailError)).isDisplayed();
    }

    public boolean verifyNameFieldOnlyAlphabet(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys("1234");
        List<WebElement> error = driver.findElements(firstNameError);
        if (!error.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public boolean verifyNameFieldAcceptsValidName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys("Adarsh");
        List<WebElement> error = driver.findElements(firstNameError);
        if (error.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public boolean verifyCompanyFieldOptional(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(value+"");
        driver.findElement(lastNameField).sendKeys(value+"");
        driver.findElement(emailField).sendKeys(value+"@gmail.com");
        driver.findElement(passwordField).sendKeys(value+"");
        driver.findElement(confirmPasswordField).sendKeys(value+"");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        wait.until(ExpectedConditions.urlContains("result"));
        System.out.println("Registration successful message: "+wait.until(ExpectedConditions.visibilityOfElementLocated(result)).getText());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(result)).isDisplayed();
    }

    public boolean verifyCompanyFieldAcceptAlphanumeric(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(value+"");
        driver.findElement(lastNameField).sendKeys(value+"");
        driver.findElement(emailField).sendKeys(value+"@gmail.com");
        driver.findElement(companyField).sendKeys("AB Tech Pvt Ltd");
        System.out.println("Company Name: AB Tech Pvt Ltd");
        driver.findElement(passwordField).sendKeys(value+"");
        driver.findElement(confirmPasswordField).sendKeys(value+"");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        wait.until(ExpectedConditions.urlContains("result"));
        System.out.println("Registration successful message: "+wait.until(ExpectedConditions.visibilityOfElementLocated(result)).getText());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(result)).isDisplayed();
    }

    public boolean verifyRegisterButtonDisable(){
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        return driver.getCurrentUrl().contains("result");
    }

    public boolean verifyRegistrationButtonEnabledOnValidMandatoryField(){
        Long value = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstNameField));
        driver.findElement(firstNameField).sendKeys(value+" ");
        driver.findElement(lastNameField).sendKeys(value+" ");
        driver.findElement(emailField).sendKeys(value+"@gmail.com");
        driver.findElement(passwordField).sendKeys(value+" ");
        driver.findElement(confirmPasswordField).sendKeys(value+" ");
        WebElement el = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",el);
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        wait.until(ExpectedConditions.urlContains("result"));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(result)).isDisplayed();
    }

    public boolean verifyRegistrationPageLoadSpeed(){
        Long start = System.currentTimeMillis();
        System.out.println("Start Time: "+start+" ms");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).isDisplayed();
        driver.findElement(registerButton).isDisplayed();
        Long end = System.currentTimeMillis();
        System.out.println("End Time: "+end+" ms");
        if ((end-start)<2500){
            System.out.println("Page load time: "+((end-start)+" ms."));
            System.out.println("Page load smoothly within 2.5 sec.");
            return true;
        }else {
            System.out.println("Page did not load within 2.5 sec.");
            return false;
        }
    }
}
