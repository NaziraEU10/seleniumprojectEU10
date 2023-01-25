package com.cydeo.tests.day3_CssSelectorXpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    public static void main(String[] args) {
        //NextBaseCRM,locators,getText(),getAttribute() practice
        //open a Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //go to https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //verify "remember me" label text is as expected:
        //Expected: Remember me on this computer

        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));

        String expectedRememberMeLabel="Remember me on this computer";
        String actualRememberMeLabel=rememberMeLabel.getText();

        if(actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("Verification of label is Passed!");
        }else{
            System.out.println("Verification of label is Failed!");
        }


        //Verify "forgot password" link text is as expected:
        // Expected: Forgot your password?
        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));

        String expectedForgotYrPasswordLink="Forgot your password?";
        String actualForgotYrPasswordLink=forgotPassword.getText();

        if(actualForgotYrPasswordLink.equals(expectedForgotYrPasswordLink)){
            System.out.println("Forgot Verification Passed!");
        }else {
            System.out.println("actualForgotYrPasswordLink = " + actualForgotYrPasswordLink);
            System.out.println("expectedForgotYrPasswordLink = " + expectedForgotYrPasswordLink);

            System.out.println("Forgot Verification Failed!");
        }

        //Verify "forgot password" href attribute's value contains expected:
        //Expected: forgot_password=yes
       String expectedInHref = "forgot_password=yes";
        String actualInHrefAttributeValue =forgotPassword.getAttribute("href");

        System.out.println("actualInHrefAttributeValue = " + actualInHrefAttributeValue);

        if(actualInHrefAttributeValue.contains(expectedInHref)){
            System.out.println("Href attribute verification Passed!");
        }else{
            System.out.println("Href attribute verification Failed!");
        }
    }
}
