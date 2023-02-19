package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.pages.DynamicLoadPage1;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriveWaitPractices {

    @Test
    public void dynamic_load_7_test(){
        //1. Go to: //https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is "Dynamic title"
       //creating the wait object to be able to create certain condition to wait
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);

        //use the 'wait' object to create out expected condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //create object of DynamicLoad7Page to reach and assert web elements
        DynamicLoad7Page dynamicLoad7Page=new DynamicLoad7Page();

        //3. Assert: Message "Done" is displayed
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        //4. Assert: Image is displayed
        Assert.assertTrue(dynamicLoad7Page.spongeBobImage.isDisplayed());


    }

    @Test
    public void dynamic_load_1_test(){
        //1.go to https://practice.cydeo.com/dynamic_loading/1
       Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicLoadPage1 dynamicLoadPage1=new DynamicLoadPage1();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        //2. click to start
       dynamicLoadPage1.startButton.click();

        //3.wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoadPage1.loadingBar));

        //4.assert username inputbox is displayed
        Assert.assertTrue(dynamicLoadPage1.inputUserName.isDisplayed());

        //5. enter username: tomsmith
        dynamicLoadPage1.inputUserName.sendKeys("tomsmith");

        //6. enter password: incorrectpassword
        dynamicLoadPage1.inputPassword.sendKeys("somethingwrongpassword");

        //7.click to submit button
        dynamicLoadPage1.submitButton.click();

        //8. assert "your password is invalid" text is displayed
        Assert.assertTrue(dynamicLoadPage1.errorMessage.isDisplayed());


    }


}
