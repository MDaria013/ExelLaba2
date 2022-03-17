package com.company;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.ArrayList;

public class Reading {


    public ArrayList<double[]> Reading(String st) throws IOException {

        XSSFWorkbook book1 = new XSSFWorkbook(st);//st = "C:\\Users\\user\\ДЗ2.xlsx"
        XSSFSheet sheet = book1.getSheetAt(7);//8 вариант


        ArrayList<double[]> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            double[] arr = new double[sheet.getLastRowNum()];
            for (int k = 1; k <= sheet.getLastRowNum(); k++) {
                arr[k - 1] = sheet.getRow(k).getCell(i).getNumericCellValue();
            }

            list.add(arr);
        }
        book1.close();

        return list;
    }

}