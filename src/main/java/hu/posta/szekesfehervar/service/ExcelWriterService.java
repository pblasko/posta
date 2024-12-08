package hu.posta.szekesfehervar.service;

import hu.posta.szekesfehervar.model.EnumCells;
import hu.posta.szekesfehervar.model.EnumURLs;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class ExcelWriterService {

    public void createWorkSheets() {
        System.out.println("step 2");
        int[][] cells = EnumCells.WorkSheet.getTwoDimensionalArray();
        String actual_URL = EnumURLs.WORKSHEET_URL.getUrl();
        String[][] allData = createData();
        excelWriter(cells, allData, actual_URL);
        System.out.println("step 3");
    }

    private String[][] createData() {
        return new String[][]{
                {"Bréda", "175", "", "", "No", "759", "Yes", "15", "44", "35", "", "187", "No", "75", "187", "Good"},
                {"Kővári", "115", "2", "33", "", "", "", "15", "14", "45", "4", "187", "No", "23", "187", "Good"},
                {"Vízvári", "175", "", "33", "No", "759", "Yes", "15", "44", "35", "", "187", "No", "75", "187", "Good"}
        };
    }

    private void excelWriter(int[][] cells, String[][] allData, String file_URL) {
        for (String[] data : allData) {
            try (FileInputStream fis = new FileInputStream(file_URL);
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
