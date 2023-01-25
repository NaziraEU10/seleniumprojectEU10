package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {
    public static void main(String[] args) {
        //open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //click to A/B Testing from top of the list
        // driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTestLink= driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();

        //verify title is:  expected:No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed!");
        }else{
            System.out.println("Title verification Failed!");
        }

        //go back to home page by using the .back()
        driver.navigate().back();

        //verify title equals: expected: Practice
        String expectedTitle2= "Practice";
        actualTitle= driver.getTitle();
        if(actualTitle.equals(expectedTitle2)){
            System.out.println("Title verification Passed!");
        }else{
            System.out.println("Title verification Failed!");
        }
    }
}
