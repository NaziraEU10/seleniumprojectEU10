package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {
    public static void main(String[] args) throws InterruptedException {
      //open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      //go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

      //click to "Add Element" button
        //button[@onclick='addElement()']
        WebElement addElementBtn = driver.findElement(By.xpath("//button[.='Add Element']"));
       Thread.sleep(2000);
        addElementBtn.click();

      //verify "Delete" button is displayed after clicking
        WebElement deleteBtn= driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());

        //Click to "Delete" button
        deleteBtn.click();

      //verify "Delete" button is NOT displayed after clicking

        try {
            System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        }catch(StaleElementReferenceException e){
            System.out.println("-->StaleElementReferenceException exception is thrown");
            System.out.println( "-->This means the web element is completely deleted from page");
            System.out.println("deleteBtn.isDisplayed()=false");
        }




        //USE XPATH LOCATOR FOR ALL WEB ELEMENT LOCATORS





    }
}
