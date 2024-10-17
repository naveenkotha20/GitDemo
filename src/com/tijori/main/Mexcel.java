package com.tijori.main;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

class Mexcel
{
	static String s="C:\\Users\\Owner\\Desktop\\Test.xls";
	static List<String> divg = new ArrayList<String>();

//static String divg;
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
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
			
			//int l=row.getLastCellNum();
			{
				int z=0;	
				for (int i=0; i<2326;i++)
				{
					row = myExcelSheet.getRow(i); 
					System.out.println(i);
		 sd=row.getCell(0).getStringCellValue();
		 
			System.out.println(sd);
	
			Earnings obj= new Earnings();
			
			divg.add(obj.getdivy(sd, driver));
			
			System.out.println("DIVG VALUES"+divg);
			 String str=divg.get(0);
			 boolean ques =str.contains("?");
		        String[] parts = str.split("\\?");

//Example obj1=new Example();
		        for (int k= 0; k < parts.length; k++) {
		        	if(k==0)
		        	{
		            System.out.println("key" + parts[k]);
		            
		        	
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);
		            
		        	}
		        	if(k==1)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println("Value1" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		        	if(k==2)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println("Value1" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		        	
		        	if(k==3)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println("Value3" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		        	
		         	if(k==4)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println("PE" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	
		        	if(k==5)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println("RAISE FROM LOW" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		        	
		           	if(k==6)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println("PRICE TO CASHFLOWS" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==7)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println("VALUATION FACTOR" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	
		         	if(k==8)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"TAX FACTOR" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	
		         	if(k==9)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==10)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==11)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==12)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==13)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==14)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==15)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==16)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==17)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==18)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	if(k==19)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            }
		         	
		          	if(k==20)
		        	{
		        		//values.add(parts[k]);
			        	//hm.put(parts[k], values);
		        		
		         System.out.println(sd+"CFO" + parts[k]);
		         
		            Example.writeToExcel("C:\\Users\\Owner\\Desktop\\Test3.xlsx", "Sheet1", k,z, parts[k]);

		            System.out.println("ENTER");
		            }
		        }
		    //	z++;
				/*
				 * for (Entry<String, List<String>> entry : hm.entrySet()) { String key =
				 * entry.getKey(); List<String> value = entry.getValue(); System.out.println(key
				 * + " -> " + value); }
				 */ 			
		        divg.clear();
				 if (ques==true)
				 {
z++;			

				 }
}
}
}
}