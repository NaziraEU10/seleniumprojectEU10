package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;

    @Test
    public void required_field_error_message_test(){
      //1. Open Chrome browser
      //2. got to: https://library1.cydeo.com/
        Driver.getDriver().get("https://library1.cydeo.com/");

      //3. do not enter any information
        //4. click to "Sign in" button
         libraryLoginPage=new LibraryLoginPage();
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
        Driver.getDriver().get(" https://library1.cydeo.com/");

      //3. enter invalid email format
        libraryLoginPage=new LibraryLoginPage();
        libraryLoginPage.inputUserName.sendKeys("somethingwrong");
        libraryLoginPage.signInButton.click();

        //4. verify expected error is displayed:
      //expected: Please enter a valid email address
       Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());



    }
}
