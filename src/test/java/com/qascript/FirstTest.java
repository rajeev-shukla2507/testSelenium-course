package com.qascript;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTest {


    @Test
    public void OpenBrowser()  {
        WebDriver driver;
        
String chromedriverPath=System.getProperty("user.dir")+"/src/test/resources/chromedriver";
		
		
		System.out.println(System.getProperty("os.name"));
		if(System.getProperty("os.name").toLowerCase().contains("win")){
			   chromedriverPath+=".exe";
				
		}else if (System.getProperty("os.name").toLowerCase().contains("linux")){
			
				
			   //chromedriverPath+="_linux";
			chromedriverPath = "/usr/bin/chromedriver";
			   
		}
			
		System.out.println("chromedriverPath: "+chromedriverPath);
		System.setProperty("webdriver.chrome.driver",chromedriverPath);
		
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println("Title of the page is: " + driver.getTitle());
        Assert.assertTrue("Page title is not correct",driver.getTitle().equals("Google"));
    }


}


