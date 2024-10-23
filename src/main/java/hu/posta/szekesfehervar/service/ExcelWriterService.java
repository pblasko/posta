package hu.posta.szekesfehervar.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class ExcelWriterService {

    public static String filePath = "/Users/blaskopeter/Desktop/posta1.xlsx";
    public static int[][] cells = {
        {1, 3},
        {2, 3},
        {3, 3},
        {4, 3},
        {5, 3},
        {6, 3},
        {7, 3},
        {8, 3},
        {9, 3},
        {10, 3},
        {11, 3},
        {12, 3},
        {1, 4},
        {2, 4},
        {13, 4},
        {14, 4}
    };
    public static String [][] datas = {
        {"Bréda", "75", "", "", "No", "759", "Yes", "15", "44", "35", "", "187", "No", "75", "187", "Good"},
        {"Kővári", "15", "2", "33", "", "", "", "15", "14", "45", "4", "187", "No", "23", "187", "Good"},
        {"Vízvári", "75", "", "33", "No", "759", "Yes", "15", "44", "35", "", "187", "No", "75", "187", "Good"}
    };

    public void newExcelWriter () {
        for(String [] data : datas) {
            try (FileInputStream fis = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0);
                IntStream.range(0, data.length).forEach(dataIndex -> {
                    Row row = sheet.getRow(cells[dataIndex][0]);
                    if (row == null) {
                        row = sheet.createRow(cells[dataIndex][0]);
                    }
                    Cell cell = row.getCell(cells[dataIndex][1]);
                    if (cell == null) {
                        cell = row.createCell(cells[dataIndex][1]);
                    }
                    cell.setCellValue(data[dataIndex]);
                });
                try (FileOutputStream fos = new FileOutputStream("/Users/blaskopeter/Desktop/" + data[0] + ".xlsx")) {
                    workbook.write(fos);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
