package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecutor {
    @Test
    public void task7_scroll_test(){
      //open a Chrome browser
      //go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink=Driver.getDriver().findElement(By.linkText("Home"));
//downCasting our driver type to JavascriptExecutor, so we are able to use the methods coming from that interface
        JavascriptExecutor js =(JavascriptExecutor) Driver.getDriver();

        //scroll down to "Cydeo" link
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);


        //scroll up to "Home" link
       // js.executeScript("arguments[1].scrollIntoView(true)",cydeoLink,homeLink);
        js.executeScript("arguments[0].scrollIntoView(true)",homeLink);

        //objects
        //cydeoLink  0
        //homeLink   1
        //someOtherLink  2

      //use below provided JS method only
      //JavaScript method to use: arguments[0].scrollIntoView(true)



    }
}
