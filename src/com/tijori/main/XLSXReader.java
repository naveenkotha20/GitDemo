package com.tijori.main;
 
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader {
    public static void main(String[] args) {
        // Path to the XLSX file
        String filePath = "C:\\Users\\Owner\\Desktop\\Test4.xlsx";

        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            // Assuming the data is present in the first two columns (A and B)
            int columnAIndex = 0; // Index of the first column (A)
            int columnBIndex = 1; // Index of the second column (B)

            // Get the first sheet from the XLSX file
            XSSFSheet sheet = workbook.getSheetAt(0);
			StringBuilder sb = new StringBuilder();
			String dataB = null;
            // Iterate through rows and read data from the specified columns
            for (Row row : sheet) {
                Cell cellA = row.getCell(columnAIndex);
                Cell cellB = row.getCell(columnBIndex);

                if (cellA != null && cellB != null) {
                    // Assuming the cells contain String data
                    String dataA = cellA.getStringCellValue();
                   dataB = cellB.getStringCellValue();
                 //   System.out.println("Column A: " + dataA + ", Column B: " + dataB);
                    sb.append(dataB);
                  
               	

                }
            
               
            
            }
            
            SentenceProcessor obj=new SentenceProcessor();
            obj.getkeywords(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
