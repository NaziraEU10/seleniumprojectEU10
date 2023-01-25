package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T7_BankHeaderVerification {
    public static void main(String[] args) {
        //open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //verify header text
        //expected: "Log in to ZeroBank"
         String expectedHeaderText= "Log in to ZeroBank";
        WebElement actualHeaderText= driver.findElement(By.tagName("h3"));
        if(expectedHeaderText.equals(actualHeaderText)){
            System.out.println("Header text verification Passed");
        }else{
            System.out.println("Header text verification Failed");
        }
       driver.close();
    }
}
