package com.qascript;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {


	@Test
    public void testOpenBrowser()  {
        WebDriver driver;
        
        String chromedriverPath=System.getProperty("user.dir")+"/src/test/resources/";
		
		
		System.out.println(System.getProperty("os.name"));
		if(System.getProperty("os.name").toLowerCase().contains("win")){
			   chromedriverPath+="win/chromedriver.exe";
				
		}else if (System.getProperty("os.name").toLowerCase().contains("linux")){
			
				
			  chromedriverPath+= "linux/chromedriver";
			//chromedriverPath = "/usr/bin/chromedriver";
			   
		}if  (System.getProperty("os.name").toLowerCase().contains("mac")){
			
			
			  chromedriverPath+= "mac/chromedriver";
			//chromedriverPath = "/usr/bin/chromedriver";
			   
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
        Assert.assertTrue(driver.getTitle().equals("Google"),"Page title is not correct");
    }


}


