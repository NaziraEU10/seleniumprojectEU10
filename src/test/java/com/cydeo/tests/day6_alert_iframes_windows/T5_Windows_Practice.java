package com.cydeo.tests.day6_alert_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class T5_Windows_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //1.open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. go to website: http://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void multiple_window_test(){

      //storing the main page's window handle as string is good practice for future re-usable purposes
        String mainHandle= driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        //Assert: Title is "Windows"
        String expectedTitle="Windows";
        String actualTitle= driver.getTitle();

        assertEquals(actualTitle,expectedTitle);

        System.out.println("Title before click: "+actualTitle);

        //click to: "Click Here" link
        WebElement clickHereLink= driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();


        //switch to new Window
    for(String each: driver.getWindowHandles()){
        driver.switchTo().window(each);
        System.out.println("Current title while switching windows: "+driver.getTitle());
    }
        //Assert: Title is "New Window"
        String expectedTitleAfterClick="New Window";
        actualTitle= driver.getTitle();

        //Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Title after click: "+actualTitle);

    }
  @AfterMethod
    public void tearDown(){
        driver.quit();
  }

}
