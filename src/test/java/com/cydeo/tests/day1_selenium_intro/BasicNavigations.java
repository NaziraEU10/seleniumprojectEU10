package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
       //1. set up browser driver
        WebDriverManager.chromedriver().setup();

        //2.create instance of the Selenium driver
       // this is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        //this line will maximize the browser size
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();  for mac

        //3.go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //get the title of the page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);


        //stop code execution for 3 sec
        Thread.sleep(3000);

        //use Selenium to navigate back
        driver.navigate().back();

        //stop code execution for 3 sec
        Thread.sleep(3000);

        //use Selenium to navigate forward
        driver.navigate().forward();

        //stop code execution for 3 sec
        Thread.sleep(3000);

        //use Selenium to navigate refresh
        driver.navigate().refresh();

        //stop code execution for 3 sec
        Thread.sleep(3000);

        //use navigate().to():
        driver.navigate().to("https://google.com");
        WebElement acceptAll= driver.findElement(By.id("L2AGLb"));
        acceptAll.click();

        //
        currentTitle= driver.getTitle();
       //get the title of the page
        // System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("currentTitle = " + currentTitle);

        //Get the current URL using Selenium
        currentURL= driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //this will close the currently opened window
        driver.close();

        //this will close all of the opened windows
        driver.quit();

    }
}
