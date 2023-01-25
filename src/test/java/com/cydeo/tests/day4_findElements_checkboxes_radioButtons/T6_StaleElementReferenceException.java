package com.cydeo.tests.day4_findElements_checkboxes_radioButtons;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {
    public static void main(String[] args) {
        //open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //go to https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //locate "CYDEO" link,verify it is displayed.
        WebElement cydeoLink= driver.findElement(By.xpath("//a[text()='CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //refresh the page
         driver.navigate().refresh();
         
        //verify it is displayed,again
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

    }
}
