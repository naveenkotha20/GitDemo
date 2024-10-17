package com.tijori.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class ExcelSearch {
	

    public void getsector (String searchkey,PrintStream myconsole) {
    
        String filePath = "C:\\Users\\Owner\\Desktop\\Test4.xlsx";
       // String searchKey = "YourSearchString";

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {
      // myconsole= new PrintStream(("C:\\Users\\Owner\\Desktop\\test.log"));
        	
        	System.setOut(myconsole);
        	
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            int rowCount = sheet.getLastRowNum();
            int foundCount = 0;
           
            
            ArrayList<String> allwords = new ArrayList<>();
            Map<String, String> stringMap = new HashMap<>();

        

            for (int i = 0; i <= rowCount; i++) { // Start from 1 to skip header row
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(1); // Assuming the search column is the second column (index 1)

                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        String[] words = cellValue.split("\\W+");
                        for(String ss: words)
                        {
                            String lowercaseWord = ss.toLowerCase();
                        if (lowercaseWord.equalsIgnoreCase(searchkey))
                        {
                        	
                            String firstColumnValue = row.getCell(0).getStringCellValue(); // Assuming the first column (index 0) contains the corresponding data
                         //   System.out.println(searchkey + (i + 1) + ": " + firstColumnValue);
                        //	biMap.put(searchkey, firstColumnValue);
                        //	biMap.put("alpha", 2);
                        //	biMap.put("word", 1);
                        //	System.out.println(biMap.get("word")); // prints 1
                        //	System.out.println(biMap.inverse().get(1)); // prints word	
                            stringMap.put(searchkey, firstColumnValue);
                            foundCount++;

                            
                            myconsole.println(searchkey + ": " + firstColumnValue);
                        }   
                        }
                    }
                }
            }

            if (foundCount == 0) {
                System.out.println("Search string not found in the second column.");
            } else {
                System.out.println("Total occurrences: " + foundCount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
