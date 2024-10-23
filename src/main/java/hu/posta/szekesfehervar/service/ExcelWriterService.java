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

    public void excelWriter () {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(1);
            if (row == null) {
                row = sheet.createRow(1);
            }
            Cell cell = row.getCell(4);
            if (cell == null) {
                cell = row.createCell(4);
            }
            cell.setCellValue("Új érték");


            try (FileOutputStream fos = new FileOutputStream("/Users/blaskopeter/Desktop/postaDemo2.xlsx")) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
