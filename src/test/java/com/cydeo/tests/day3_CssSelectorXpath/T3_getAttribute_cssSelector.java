package com.cydeo.tests.day3_CssSelectorXpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {
    public static void main(String[] args) {
        //1.open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. go to https://login1.nextbasecrm.com
        driver.get("https://login1.nextbasecrm.com");

        //3.verify "Log in" button text is as expected:
        //Expected: Log In
        //WebElement signInButton = driver.findElement(By.className("login-btn"));

 // LOCATING THE SAME WEB ELEMENT USING DIFFERENT ATTR-TE VALUES
//                   tagName[attribute='value']
//                   input[class='login-btn'

//LOCATED USING CLASS ATTRIBUTE
       // WebElement signInButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

//LOCATED USING TYPE ATTRIBUTE
       // WebElement signInButton = driver.findElement(By.cssSelector("input[type='submit']"));

//LOCATED USING VALUE ATTRIBUTE
        WebElement signInButton = driver.findElement(By.cssSelector("input[value='Log In']"));
      String expectedBtnText="Log In";

//Getting the value of the attribute "value"
      String actualBtnText= signInButton.getAttribute("value");
      System.out.println("actualBtnText = " + actualBtnText);

      if(actualBtnText.equals(expectedBtnText)){
          System.out.println("Log In button text verification Passed!");
      }else{
          System.out.println("Log In button text verification Failed!");
      }


    }
}
