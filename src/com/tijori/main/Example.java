package com.tijori.main;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Example {
    public static void writeToExcel(String filename, String sheetname, int x, int y, String value) throws IOException {
        // open the existing workbook
        FileInputStream in = new FileInputStream(new File(filename));
        XSSFWorkbook workbook = new XSSFWorkbook(in);
     //   in.close();

        // get the sheet to write to
        XSSFSheet sheet = workbook.getSheet(sheetname);
        if (sheet == null) {
            sheet = workbook.createSheet(sheetname);
        }

        // get the row to write to
        XSSFRow row = sheet.getRow(y);
		 if (row == null) { row = sheet.createRow(y); }
		 
        // get the cell to write to
        XSSFCell cell = row.getCell(x);
        if (cell == null) {
            cell = row.createCell(x);
        }

        // set the value of the cell
        cell.setCellValue(value);

        // write the workbook back to the file
        FileOutputStream out = new FileOutputStream(new File(filename));
        workbook.write(out);
        out.close();

        // close the workbook
        workbook.close();
    }
}
