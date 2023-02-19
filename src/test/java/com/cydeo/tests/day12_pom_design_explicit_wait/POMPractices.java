package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class POMPractices {

    @Test
    public void Required_field_error_message_test(){
      //1. Open Chrome browser
      //2. got to: https://library1.cydeo.com/
        Driver.getDriver().get("https://library1.cydeo.com/");

      //3. do not enter any information
        //4. click to "Sign in" button
        LibraryLoginPage libraryLoginPage=new LibraryLoginPage();

      //5. verify expected error is displayed:
      //expected: This field is required





    }
}
