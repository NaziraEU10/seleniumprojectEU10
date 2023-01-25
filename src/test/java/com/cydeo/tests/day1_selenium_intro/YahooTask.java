package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooTask {
    public static void main(String[] args) {

        //set up the web page driver
        WebDriverManager.chromedriver().setup();

        //create instance of selenium driver
        WebDriver driver=new ChromeDriver();

        //make our page fullscreen
        driver.manage().window().fullscreen();

        //go to https://www.yahoo.com
        driver.get(" https://www.yahoo.com");

        //Verify title
        //expected: Yahoo|  email, weather, search, news, sports and more
        String expectedTitle="Yahoo|  email, weather, search, news, sports and more";

        //actual title comes from browser
        String actualTitle= driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected.Verification Passed.");
        }else{
            System.out.println("Title is NOT as expected.Verification Failed.");
        }

        //this will close the currently opened window
       driver.close();
    }
}
