package com.cydeo.tests.day3_CssSelectorXpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {
    public static void main(String[] args) {
        //1. open Chrome browser
      //  WebDriverManager.chromedriver().setup();
      //  WebDriver driver=new ChromeDriver();
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2 go to https://login1.nextbasecrm.com
        driver.get("https://login1.nextbasecrm.com");

        //3. enter incorrect username:"incorrect"
       // driver.findElement(By.className("login-inp")).sendKeys();
        WebElement inputUsername= driver.findElement(By.className("login-inp"));
        inputUsername.sendKeys("incorrect");

        //4. enter incorrect password:"incorrect"
        //to autogenerate local variable option+enter
        WebElement inputPassword= driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");

        //5.click to log in button
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
        //6.verify error message text is as expected
        //expected: Incorrect login or password
         WebElement errorMessage= driver.findElement(By.className("errortext"));
         String expectedErrorMessage="Incorrect login or password";
         String actualErrorMessage=errorMessage.getText();

         if(actualErrorMessage.equals(expectedErrorMessage)){
             System.out.println("Error message verification Passed!");
         }else{
             System.out.println("Error message verification Failed!");
         }
    }
}
