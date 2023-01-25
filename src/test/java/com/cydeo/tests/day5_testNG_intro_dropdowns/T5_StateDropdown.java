package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_StateDropdown {

    //TC #5: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void tearDownTest() {
        driver.quit();
   }

    @Test
    public void stateDropdownTest() {
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown ");

        //find select tag with "state" id
        Select statesDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        statesDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        statesDropdown.selectByValue("VA");
        //5. Select California
        statesDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        Assert.assertEquals(statesDropdown.getFirstSelectedOption().getText(),"California");
        //Use all Select options. (visible text, value, index)
        //
    }
}
