package com.tijori.main;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

class Sector
{
	static String s="C:\\Users\\Owner\\Desktop\\Test.xls";
	static List<String> divg = new ArrayList<String>();

//static String divg;
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException, AWTException {
		WebDriver driver;
		Map<String, List<String>> hm = new HashMap<String, List<String>>();
		List<String> values = new ArrayList<String>();
		//ProfilesIni profile = new ProfilesIni();
		//FirefoxProfile myprofile = profile.getProfile("default");
		//driver=new FirefoxDriver();
		 System.setProperty(
		            "webdriver.chrome.driver",
		            "C:\\Users\\Owner\\Downloads\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.get("https://www.screener.in");
			driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			
			driver.findElement(By.xpath("//a[@class='button account']")).click();
			
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("naveenkotha20@gmail.com");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Naveen@1990");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			 String sd;
//Thread.sleep(20000);
		    HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(s)); 
			HSSFSheet myExcelSheet = myExcelBook.getSheet("sheet1"); 
			HSSFRow row = myExcelSheet.getRow(0); 
			int l=row.getLastCellNum();
			HSSFPalette palette = myExcelBook.getCustomPalette();
			// get the color which most closely matches the color you want to use
			HSSFColor myColor = palette.findSimilarColor(255, 0, 0);
			// get the palette index of that color 
			short palIndex = myColor.getIndex();
			StringBuilder sb = new StringBuilder();
			//int l=row.getLastCellNum();
			{
				int z=0;	
				for (int i=0; i<245;i++)
				{
					row = myExcelSheet.getRow(i); 
					System.out.println(i);
		            sd=row.getCell(0).getStringCellValue();
			        System.out.println(sd);
			        
			        try
			        {
			        driver.findElement(By.xpath("//div[@class='search']/descendant::input[@placeholder='Search for a company']")).sendKeys(sd); 
			        Thread.sleep(1000);
		        	driver.findElement(By.xpath("//div[@class='search']/descendant::input[@placeholder='Search for a company']")).sendKeys(Keys.ENTER);
					Thread.sleep(5000);
		        //	driver.findElement(By.xpath("//button[normalize-space(text())='Read More']")).click();

		        	  List<WebElement> ss=  driver.findElements(By.xpath("//p"));
		 			 
			    //  List<WebElement> ss=  driver.findElements(By.xpath("//div[@class='sub']/p"));
			 
			      int tds=ss.size();
			      
			      
			      
             for (int j=0;j<3;j++)
             {
            	 System.out.println(ss.get(j).getText());
            	 sb.append(ss.get(j).getText());

             }
			//Thread.sleep(1000);	
			//span[normalize-space(text())='Market Cap']
			//driver.findElement(By.xpath("//span[normalize-space(text())='Market Cap']")).click();
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_ESCAPE);
			 * robot.keyRelease(KeyEvent.VK_ESCAPE); Thread.sleep(1000);
			 */
				}
			        catch(Exception e)
			        {
			        	System.out.println(e);
			        }
			        
			    finally
			    {
			    	
			    }
			        
				}
				
				
}
			System.out.println(sb.toString());
SentenceProcessor obj=new SentenceProcessor();
obj.getkeywords(sb.toString());
	}
}