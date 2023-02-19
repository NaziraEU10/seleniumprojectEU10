package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.cydeo.utilities.Driver.getDriver;

public class ActionsPractices {

    @Test
    public void task_4_and_5_test() {
        //Task 4:Scroll practice
        // Open Chrome Browser
        //go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //Scroll down to "Powered by CYDEO"
        // Create object of Actions and pass our "driver" instance
        Actions actions = new Actions(Driver.getDriver());

        //locating cydeo link to be able to pass in the actions method
        WebElement cydeoLink = getDriver().findElement(By.linkText("CYDEO"));

        //Scroll using Actions class "moveTo(element)"method
        actions.moveToElement(cydeoLink).perform();

        //Scroll back up to "Home" link using PageUp button.
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

        //Driver.getDriver().close();
        Driver.closeDriver();
    }

       @Test
     public void test2(){
           Driver.getDriver().get("https://practice.cydeo.com/");
           Driver.closeDriver();



        }
}

