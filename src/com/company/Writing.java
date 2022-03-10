package com.company;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writing {

    public void Writing(Calculation C, String st) throws IOException {

        XSSFWorkbook book2 = new XSSFWorkbook();
        XSSFSheet sheet = book2.createSheet("Мичурина");

        sheet.setColumnWidth(0, 6200);

        for (int i=1; i <= 3; i++ ){
        sheet.setColumnWidth(i, 4000);}

        XSSFRow row0 = sheet.createRow(0);
        row0.createCell(1, CellType.STRING).setCellValue("x");
        row0.createCell(2, CellType.STRING).setCellValue("y");
        row0.createCell(3, CellType.STRING).setCellValue("z");


        int i = 1;
        for (Object str : C.lhm().keySet()) {
            XSSFRow row = sheet.createRow(i);
            row.createCell(0, CellType.STRING).setCellValue((String) str);
            for (int k = 0; k < 3; k++) {
                row.createCell(k + 1, CellType.NUMERIC).setCellValue(C.lhm().get(str)[k]);
            }
            i++;
        }

        File file = new File(st);//st = "C:\\Users\\user\\newДЗ2.xlsx"
        book2.write(new FileOutputStream(file));
        book2.close();

    }}

