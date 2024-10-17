package com.tijori.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class CrossBrowser {
	
	WebDriver driver;
	
	public WebDriver openBrowser(String browsername) {
		
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		
		

		if (browsername.equalsIgnoreCase("firefox")) {
		
		//WebDriver driver = new FirefoxDriver();
		

		  //  WebDriver driver=new FirefoxDriver(options);

	   
	    FirefoxOptions options=new FirefoxOptions().setProfile(myprofile);
	    driver = new FirefoxDriver(options);
	    
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");


		}
		
		else if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naveen\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "H:\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();	
		}
		
		driver.manage().window().maximize();
		
		System.out.println("Exit Cross Browser Class");
		return driver;
	}

}
