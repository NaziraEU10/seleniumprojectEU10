package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForthNavigation {
    public static void main(String[] args) {
        //open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //go to: https://google.com
        driver.get("https://google.com");
        WebElement acceptAll= driver.findElement(By.id("L2AGLb"));
        acceptAll.click();
        //click Gmail from top to right.
         WebElement clickOnGmail = driver.findElement(By.linkText("Gmail"));
         clickOnGmail.click();
        // Verify title contains:
        //  Expected: Gmail
        String expectedTitle ="Gmail";
        String actualTitle = driver.getTitle();

        if(expectedTitle.contains(actualTitle)){
            System.out.println("Title verification passed!");
        }else{
            System.out.println("Title verification failed!");
        }
        // Go back to Google by using the .back();
        driver.navigate().back();

        //Verify title equals:
        //  Expected: Google
        String expectedTitle2= "Google";
        String actualTitle2= driver.getTitle();
        if(expectedTitle2.equals(actualTitle2)){
            System.out.println("Title 2 verification passed!");
        }else{
            System.out.println("Title 2 verification failed!");
        }
    }
}
