package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T6_EtsyTitleVerification {
    public static void main(String[] args) {

        //Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        driver.findElement(By.xpath("//button[@class = 'wt-btn wt-btn--filled wt-mb-xs-0']")).click();

        //search for "wooden spoon"
        WebElement etsySearchBox = driver.findElement(By.name("search_query"));
        etsySearchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        //verify title:    expected:"Wooden spoon|Etsy"
         String expectedTitle = "Wooden spoon|Etsy";
         String actualTitle= driver.getTitle();

         if(expectedTitle.equals(actualTitle)){
             System.out.println("Title verification Passed!");
         }else{
             System.out.println("Title verification Failed!");
         }
        driver.close();
    }
}