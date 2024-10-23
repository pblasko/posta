package hu.posta.szekesfehervar.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class ExcelWriterService {

    public static String filePath = "/Users/blaskopeter/Desktop/posta1.xlsx";
    public static String [][] arrays = {
            {"1", "3", "No"},
            {"2", "3", "75"},
            {"3", "3", ""},
            {"4", "3", ""},
            {"5", "3", "No"},
            {"6", "3", "759"},
            {"7", "3", "Yes"},
            {"8", "3", "15"},
            {"9", "3", "44"},
            {"10", "3", "35"},
            {"11", "3", ""},
            {"12", "3", "187"},
            {"1", "4", "No"},
            {"2", "4", "75"},
            {"13", "4", "187"},
            {"14", "4", "Good"}
    };

    public void excelWriter () {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0);

                for(String [] array : arrays) {
                    Row row = sheet.getRow(Integer.parseInt(array[0]));
                    if (row == null) {
                        row = sheet.createRow(Integer.parseInt(array[0]));
                    }
                    Cell cell = row.getCell(Integer.parseInt(array[1]));
                    if (cell == null) {
                        cell = row.createCell(Integer.parseInt(array[1]));
                    }
                    cell.setCellValue(array[2]);
                }

            try (FileOutputStream fos = new FileOutputStream("/Users/blaskopeter/Desktop/postaDemo3.xlsx")) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
