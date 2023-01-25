package com.cydeo.tests.day4_findElements_checkboxes_radioButtons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T7_wiredHeadphone {
    public static void main(String[] args) {
       WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.flipkart.com");

        WebElement element= driver.findElement(By.xpath("//html"));
        element.click();

       WebElement wiredHeadphoneBtn= driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[4]/a/div[2]/div/div/text()"));

////*[@id="container"]/div/div[2]/div/div/div[4]/a/div[2]/div/div/text()


        /*WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.flipkart.com/");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.navigate().refresh();
        //driver.findElement(By.xpath("(//button[@class])[2]")).click();

        driver.quit();
*/

    }
}