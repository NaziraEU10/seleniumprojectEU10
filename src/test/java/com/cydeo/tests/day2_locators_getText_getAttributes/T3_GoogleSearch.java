package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {
        //open Chrome browser
              WebDriverManager.chromedriver().setup();
              WebDriver driver=new ChromeDriver();
             driver.manage().window().maximize();

       //go to https://google.com
       driver.get("https://google.com");
        WebElement acceptAll= driver.findElement(By.id("L2AGLb"));
        acceptAll.click();

       //write "apple" in search box
        //click google search button
        //press Enter using Keys.ENTER
        WebElement googleSearchBox=driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);


        //verify title:expected: title should start with apple word
        String expectedInTitle ="apple";
        String actualTitle2= driver.getTitle();
        if(actualTitle2.startsWith(expectedInTitle)){
            System.out.println("Title verification Passed!");
        }else {
            System.out.println("title verification Failed!");
        }
    }
}
