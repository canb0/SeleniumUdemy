package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AppTest{

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL;//= "http://www.swtestacademy.com/";
    public String browser;

    @BeforeMethod
    public void setupTest (){
        browser = System.getProperty("browser");
        testURL = System.getProperty("url");


        //Print console that code is in @BeforeMethod!
        System.out.println("@BeforeMethod has started.");

        if(browser.contains("Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        }else if (browser.contains("FireFox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }else if (browser.contains("CloudChrome")){
        }
    }
    //-----------------------------------Tests-----------------------------------
    @Test
    public void firstTest () {
        System.out.println("First Test is Started.");
        //Go to www.swtestacademy.com
        driver.navigate().to(testURL);
        //Get page title
        String title = driver.getTitle();
        //Print page's title
        System.out.println("Page Title: " + title);
        Assert.assertTrue(title.contains("Academy"));
    }

    @AfterMethod
    public void teardownTest (){
        System.out.println("@AfterMethod has started.");
        driver.quit();
    }
}
