package com.tijori.main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

class tes
{
	static String s="C:\\Users\\Owner\\Desktop\\Test.xls";
	
	static List<String> divg = new ArrayList<String>();
	
//static String divg;
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		
		  HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(s)); 
		  
			HSSFSheet myExcelSheet = myExcelBook.getSheet("sheet1"); 
			
			HSSFRow row = myExcelSheet.getRow(0); 
			
			int l=row.getLastCellNum();
			//int l=row.getLastCellNum();
						
			{
				
				for (int i=1; i<205;i++)
				{
					row = myExcelSheet.getRow(i); 
					
		 String sd=row.getCell(0).getStringCellValue();
		 
			System.out.println(sd);
			
			Test obj=new Test();
			
			divg.add(obj.getdivy(sd));
			
			System.out.println("DIVG VALUES"+divg);
			
				}
				
			}
			
			}
}

 