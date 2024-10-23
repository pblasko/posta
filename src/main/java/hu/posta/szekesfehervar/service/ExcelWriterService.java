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
    public static String [] names = {"Bréda Attila", "Kővári László", "Vízvári Róbert"};
    public static int index = 0;
    public static String [][][] arrays = {
        {
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
        }, {
            {"1", "3", "Yes"},
            {"2", "3", "15"},
            {"3", "3", "2"},
            {"4", "3", "33"},
            {"5", "3", ""},
            {"6", "3", ""},
            {"7", "3", ""},
            {"8", "3", "15"},
            {"9", "3", "14"},
            {"10", "3", "45"},
            {"11", "3", "4"},
            {"12", "3", "187"},
            {"1", "4", "No"},
            {"2", "4", "23"},
            {"13", "4", "187"},
            {"14", "4", "Good"}
        }, {
            {"1", "3", "No"},
            {"2", "3", "75"},
            {"3", "3", ""},
            {"4", "3", "33"},
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
        }
    };

    public void excelWriter () {
        for(String [][] array : arrays) {
            try (FileInputStream fis = new FileInputStream(filePath);
                 XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0);

                for(String [] data : array) {
                    Row row = sheet.getRow(Integer.parseInt(data[0]));
                    if (row == null) {
                        row = sheet.createRow(Integer.parseInt(data[0]));
                    }
                    Cell cell = row.getCell(Integer.parseInt(data[1]));
                    if (cell == null) {
                        cell = row.createCell(Integer.parseInt(data[1]));
                    }
                    cell.setCellValue(data[2]);
                }
                try (FileOutputStream fos = new FileOutputStream("/Users/blaskopeter/Desktop/" + names[index] + ".xlsx")) {
                    workbook.write(fos);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            index++;
        }
    }

}
