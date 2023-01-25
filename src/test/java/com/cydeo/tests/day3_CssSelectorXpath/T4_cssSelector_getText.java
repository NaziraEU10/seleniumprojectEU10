package com.cydeo.tests.day3_CssSelectorXpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {
        //1.open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2.go to https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3.verify- "reset password" button text is as expected:
        //Expected: Reset password

        //LOCATING RESET PASSWORD BUTTON USING CLASS ATTRIBUTE AND ITS VALUE
        // WebElement resetPasswordButton= driver.findElement(By.cssSelector("button[class='login-btn']"));

        //LOCATING RESET PASSWORD BUTTON USING VALUE ATTRIBUTE AND ITS VALUE
        WebElement resetPasswordButton= driver.findElement(By.cssSelector("button[value='Reset password']"));

        String expectedResetPasswordBtn = "Reset Password";
        String actualResetPasswordBtn =resetPasswordButton.getText();

        if(actualResetPasswordBtn.equals(expectedResetPasswordBtn)){
            System.out.println("Reset password verification Passed!");
        }else{
            System.out.println("Reset password verification Failed!");
        }

    }
}
