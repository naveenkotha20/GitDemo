package com.tijori.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Extract {
	

	static String s="C:\\Users\\Owner\\Desktop\\Test.xls";
	static List<String> divg = new ArrayList<String>();
	
//static String divg;
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver;
 
		
			System.setProperty("webdriver.gecko.driver","C:\\New folder\\Chromedriver\\geckodriver.exe");
		driver= new ChromeDriver();
		
			driver.get("https://www.apeuni.com");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[.='English']")).click();
Thread.sleep(20000);
/*
		    HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(s)); 
		  
			HSSFSheet myExcelSheet = myExcelBook.getSheet("sheet1"); 
			
			HSSFRow row = myExcelSheet.getRow(0); 
			
			int l=row.getLastCellNum();
			
			
			//int l=row.getLastCellNum();
						
			{
				for (int i=1; i<3000;i++)
				{
					row = myExcelSheet.getRow(i); 
					
		 String sd=row.getCell(0).getStringCellValue();
		 
			System.out.println(sd);
			
			EPS obj= new EPS();
			
			divg.add(obj.getdivy(sd, driver));
			
			System.out.println("DIVG VALUES"+divg);
			
				}*/
			}
			
			


}
