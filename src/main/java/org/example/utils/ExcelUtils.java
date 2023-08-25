package org.example.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {
    public static List<Map<String, String>> getTestDataAsMapList() {
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        List<Map<String, String>> data = null;
        try {
            fis = new FileInputStream(FrameworkConstants.getExcelFilePath());
            workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("RUNMANAGER");
            int rowNum = sheet.getLastRowNum();
            int columnNum = sheet.getRow(0).getLastCellNum();
            data = new ArrayList<>();
            Map<String, String> map;
            for (int i = 1; i <= rowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < columnNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                data.add(map);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(fis)) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (Objects.nonNull(workbook)) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return data;
    }
}
