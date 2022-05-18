package oit.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {

    XSSFWorkbook wb = null;
    XSSFSheet sheet = null;

    public static String excelFilePath;

    public void writeDataInExcel(String filePath, String queryDiscription,
                                 int queryResultValue) throws IOException {
        //path where you wish the Excel Sheet to show
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);

            sheet = wb.getSheetAt(0);

            int lastRow = sheet.getLastRowNum();
            Row row = sheet.createRow(++lastRow);

            row.createCell(0).setCellValue(queryDiscription);
            row.createCell(1).setCellValue(queryResultValue);
            FileOutputStream fos = new FileOutputStream(file);
            wb.write(fos);

            System.out.println(queryDiscription
                    + " Added successfully in the file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void createNewExcel() throws IOException {
        CurrentDateTime date = new CurrentDateTime();
        String currentMonth = date.currentMonth();
        String firstFilePath = "./ExcelSheets/KPIs_CurrentMonth.xlsx";
        excelFilePath = firstFilePath.replace("CurrentMonth", currentMonth);
        // path where you wish the Excel Sheet to show
        File file = new File(excelFilePath);
        // Time to create a Workbook
        wb = new XSSFWorkbook();
        // Time to create the sheet
        sheet = wb.createSheet();
        // sheet.createRow(0).createCell(0).setCellValue("test");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            wb.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

