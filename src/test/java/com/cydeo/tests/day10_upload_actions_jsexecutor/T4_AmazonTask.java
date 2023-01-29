package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class T4_AmazonTask {
    @Test
    public void upload_test() {
  /*
  We expect you to automate the following steps via Selenium Web Driver, regardless of
checking for expected/actual results. We prefer Chrome as the browser, but the choice
is yours.
Notes: It may also be necessary to write code to accept the accept cookies warning.
   */

        //1. Go to https://www.amazon.com.tr/
        Driver.getDriver().get("https://www.amazon.com.tr/");

        //find and click on the 'AcceptAll' cookies button
        WebElement acceptButton=Driver.getDriver().findElement(By.xpath("//input[@id='sp-cc-accept']"));
        BrowserUtils.sleep(2);
        if(acceptButton.isDisplayed()){
            acceptButton.click();
        }

       //2. Search iPhone13 512
        WebElement searchIphone =Driver.getDriver().findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchIphone.sendKeys("iPhone13 512");
        searchIphone.submit();

      //3. Check that the results are listed
        List<WebElement> results=Driver.getDriver().findElements(By.xpath("//div[*='SONUÇLAR']"));
        for(WebElement eachResult: results){
            eachResult.click();
        }

       //4. Click iPhone13 at the top of the list
        WebElement firstIPhone13=Driver.getDriver().findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
       firstIPhone13.click();


      //5. Log the following values for each size
      //.Size information .Price .Color .Stock status
       WebElement size=Driver.getDriver().findElement(By.xpath("//div[@id=\"variation_size_name\"]/div/span"));
       String sizeValue= size.getText();
        System.out.println("Size: "+sizeValue);

        WebElement color=Driver.getDriver().findElement(By.cssSelector("#variation_color_name > div > span"));
        String colorValue=color.getText();
        System.out.println("Color: "+colorValue);

        WebElement price=Driver.getDriver().findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span/span[2]/span[1]"));
        String priceValue= price.getText();
        System.out.println("Price: "+priceValue+" TL");

        System.out.println("Stock: "+"Stokta sadece "+stockStatus()+" kaldi.");
    }

   public String stockStatus(){
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"quantity\"]/option[1]"));
        return element.getText();
   }
}
