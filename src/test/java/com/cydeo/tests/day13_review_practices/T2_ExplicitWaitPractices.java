package com.cydeo.tests.day13_review_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_ExplicitWaitPractices {

  DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage=new DynamicControlsPage();
    }
    @Test
    public void remove_button_test(){
        //3. click to "Remove" button
     dynamicControlsPage.removeButton.click();

        //4. wait until "loading bar disappears"
       /*
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
       */
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);


        //5. verify:
        //a. checkbox is not displayed
        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());
            //assertFalse method will pass the test if the boolean value return is: false
            Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }
        // b. "It's gone!" message is displayed
         Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
         Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's gone!"));

    }

}
