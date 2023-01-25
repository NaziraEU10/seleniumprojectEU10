package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_MultipleSelectDropdown {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void multipleSelectDropdownTest(){
        driver.get("https://practice.cydeo.com/dropdown ");

        //Select all the options from multiple select dropdown.
        Select multipleDropdown=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //store all options
        List<WebElement>options=multipleDropdown.getOptions();

        //this will iterate according to the size of options
        for(int i=0;i<options.size();i++){
            //this will select by index one by one
            multipleDropdown.selectByIndex(i);
        }

        //4. Print out all selected values.
       //stores all selected options
        List<WebElement>selectedOptions=multipleDropdown.getAllSelectedOptions();

        //iterates each element of selected options
        for(WebElement each: selectedOptions){
            System.out.println(each.getText());
        }

        //5. Deselect all values.
        //




    }



}
