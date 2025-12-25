package tests;

import base.BaseTest;
import listeners.ExtentListener;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Register;

@Listeners(ExtentListener.class)
public class RegisterTest extends BaseTest {

    @Test(description = "Verify registration page loads with all fields")
    public void test1(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyPageLoad(),"Register page did not load successfully with required fields.");
    }

    @Test(description = "Verify registration page UI loads correctly")
    public void test2(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyPageLoad2(),"Register page did not load successfully with required ui.");
    }

    @Test(description = "Verify successful registration with valid details")
    public void test3(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyValidLogin().contains("result"),"Valid login did not successful.");
    }

    @Test(description = "Verify confirmation message after successful registration")
    public void test4(){
        Register register = new Register(driver);
        Assert.assertEquals(register.verifyRegisteredMessage(),"Your registration completed","Message of successful registration didn't matched.");
    }

    @Test(description = "Verify validation for empty mandatory fields")
    public void test5(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyValidationForEmptyMandatoryField(),"Validation message for mandatory fields did not visible.");
    }

    @Test(description = "Verify red border for invalid mandatory fields")
    public void test6(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyRedBorderInvalidMandatoryFields(),"Red border invalid message for mandatory fields did not visible.");
    }

    @Test(description = "Verify invalid email format is rejected")
    public void test7(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyInvalidEmailFormat(),"Invalid email format error message did not visible.");
    }

    @Test(description = "Verify email field rejects spaces")
    public void test8(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifySpaceRejectEmailField(),"Invalid email format error message did not visible on test@ gmail.com");
    }

    @Test(description = "Verify duplicate email registration fails")
    public void test9(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyDuplicateEmailRegistration(),"Duplicate email error message did not visible.");
    }

    @Test(description = "Verify system blocks duplicate account creation")
    public void test10(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifySystemBlockedDuplicateEmailRegistration(),"System didn't blocked registration on duplicate email.");
    }

    @Test(description = "Verify name fields accept only alphabets")
    public void test11(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyNameFieldOnlyAlphabet(),"First name field didn't show error on numbers and special characters.");
    }

    @Test(description = "Verify name fields accept valid alphabets")
    public void test12(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyNameFieldAcceptsValidName(),"First name field shows error on valid name.");
    }

    @Test(description = "Verify company field is optional")
    public void test13(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyCompanyFieldOptional(),"Registration blocked on empty company field.");
    }

    @Test(description = "Verify company field accepts alphanumeric input")
    public void test14(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyCompanyFieldAcceptAlphanumeric(),"Company field did not accept alphanumeric input.");
    }

    @Test(description = "Verify register button disabled when mandatory fields empty")
    public void test15(){
        Register register = new Register(driver);
        Assert.assertFalse(register.verifyRegisterButtonDisable(),"Register is not disable on empty mandatory fields.");
    }

    @Test(description = "Verify register button enabled when mandatory fields valid")
    public void test16(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyRegistrationButtonEnabledOnValidMandatoryField(),"Register button is not enable on valid mandatory field.");
    }

    @Test(description = "Verify registration page loads within 2.5 sec")
    public void test17(){
        Register register = new Register(driver);
        Assert.assertTrue(register.verifyRegistrationPageLoadSpeed());
    }

    @Test(description = "Verify all JS/CSS resources load successfully")
    public void test18(){
        if(true){
            throw new SkipException("Can be done only by manual.");
        }
    }

    @Test(description = "Verify all required fields marked with *")
    public void test19(){
        if(true){
            throw new SkipException("Can be done only by manual.");
        }
    }

    @Test(description = "Verify optional fields do not contain *")
    public void test20(){
        if(true){
            throw new SkipException("Can be done only by manual.");
        }
    }
}
