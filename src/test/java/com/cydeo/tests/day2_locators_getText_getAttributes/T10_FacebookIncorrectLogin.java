package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T10_FacebookIncorrectLogin {
    public static void main(String[] args) throws InterruptedException {

        // Facebook incorrect login title verification
        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com ");

        // 3. Enter incorrect username
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("123142wr15ong@email.com");
        // 4. Enter incorrect password
        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys("wrongPassword" + Keys.ENTER);

        // 5. Verify title changed to:
        //  Expected: “Log into Facebook”
        String expectedTitle = "Log into Facebook";

        //Wait here 5 seconds for page to load before getting
        //actual title
        //You can increase time if it takes longer for you
        Thread.sleep(3000);

        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification passed!");
        } else {
            System.out.println("Title verification failed!!!");
        }
    }


}

