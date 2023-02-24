package com.cydeo.tests.day13_review_practices;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick {
    @Test
public void t1_double_click_test() {
        //1. go to
        // https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        WebElement acceptAll=Driver.getDriver().findElement((By.xpath("//*[@id=\"accept-choices\"]")));
        acceptAll.click();

        //2. Switch to iframe.
       Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double-click on the text “Double-click me to change my text color.”
        DoubleClickPage doubleClickPage=new DoubleClickPage();
        Actions actions=new Actions(Driver.getDriver());

        actions.doubleClick(doubleClickPage.textToDoubleClick).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        //NOTE: FOLLOW POM
        System.out.println("doubleClickPage.textToDoubleClick.getAttribute(\"style\") = " + doubleClickPage.textToDoubleClick.getAttribute("style"));

        String actualStyleAttributeValue=doubleClickPage.textToDoubleClick.getAttribute("style");

        String expectedStyleAttribute="red";
        Assert.assertTrue(actualStyleAttributeValue.contains(expectedStyleAttribute));
    }

}
