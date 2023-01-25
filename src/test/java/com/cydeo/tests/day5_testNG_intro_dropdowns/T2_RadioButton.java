package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton {
    public static void main(String[] args) {
       //Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       //go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

       //click to "Hockey" radio button
        WebElement hockeyRadioBtn= driver.findElement(By.xpath("//input[@id='hockey']"));

        hockeyRadioBtn.click();

       //verify "Hockey" radio button is selected after clicking
        if(hockeyRadioBtn.isSelected()){
            System.out.println("Button is selected.Verification Passed!");
        }else{
            System.out.println("Button is not selected.Verification Failed!");
        }
    }

}
