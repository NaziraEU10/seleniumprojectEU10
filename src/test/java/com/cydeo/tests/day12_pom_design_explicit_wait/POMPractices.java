package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://library1.cydeo.com/");
        libraryLoginPage=new LibraryLoginPage();
    }

    @Test
    public void required_field_error_message_test(){
      //1. Open Chrome browser
      //2. got to: https://library1.cydeo.com/
        //3. do not enter any information
        //4. click to "Sign in" button

         libraryLoginPage.signInButton.click();

      //5. verify expected error is displayed:
      //expected: This field is required
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

      Driver.closeDriver();


    }

    @Test
    public void invalid_email_format_error_message_test(){
      //1. open a Chrome browser
      //2. go to: https://library1.cydeo.com/
      //3. enter invalid email format

        libraryLoginPage.inputUserName.sendKeys("somethingwrong");
        libraryLoginPage.signInButton.click();

        //4. verify expected error is displayed:
      //expected: Please enter a valid email address
       Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());

       Driver.closeDriver();


    }

    @Test
    public void library_negative_login_test(){
        //1. Open a Chrome browser
        //2. go to: https://library1.cydeo.com
        //3. enter incorrect username or incorrect password
        libraryLoginPage.inputUserName.sendKeys("wrong@username.com");
        libraryLoginPage.inputPassword.sendKeys("wrongpassword");
        libraryLoginPage.signInButton.click();

        //4.verify title expected error is displayed
        //expected: Sorry, Wrong Email or Password
         Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

         Driver.closeDriver();
    }

}
