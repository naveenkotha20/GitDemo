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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

class Excel
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
			driver.get("https://tijorifinance.com");
			driver.manage().window().maximize();
//Thread.sleep(20000);
		    HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(s)); 
			HSSFSheet myExcelSheet = myExcelBook.getSheet("sheet4"); 
			HSSFRow row = myExcelSheet.getRow(0); 
			int l=row.getLastCellNum();
			//int l=row.getLastCellNum();
			{
				int z=0;	
				for (int i=0; i<2000;i++)
				{
					row = myExcelSheet.getRow(i); 
					System.out.println(i);
		 String sd=row.getCell(0).getStringCellValue();
		 
			System.out.println(sd);
	
			EPS obj= new EPS();
			
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
		        }
		    //	z++;
				/*
				 * for (Entry<String, List<String>> entry : hm.entrySet()) { String key =
				 * entry.getKey(); List<String> value = entry.getValue(); System.out.println(key
				 * + " -> " + value); }
				 */ 			divg.clear();
				 if (ques==true)
				 {
z++;					 
				 }
}
}
}
}