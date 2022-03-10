package com.company;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;

public class Reading {

    public double[][] Reading(String st) throws IOException {

        XSSFWorkbook book1 = new XSSFWorkbook(st);//st = "C:\\Users\\user\\ДЗ2.xlsx"
        XSSFSheet sheet = book1.getSheetAt(0);//8 вариант

        double[][] arr = new double[3][sheet.getLastRowNum()];
        for (int i = 0; i < 3; i++) {
            for (int k = 1; k <= sheet.getLastRowNum(); k++) {
                arr[i][k - 1] = sheet.getRow(k).getCell(i).getNumericCellValue();
            }
        }
        book1.close();

        return arr;
    }
}