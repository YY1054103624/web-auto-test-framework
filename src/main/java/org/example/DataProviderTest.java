package org.example;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderTest {
    @Test(dataProvider = "getDataFromExcel")
    public void testDataProvider(String username, String password, String phone, String location) {
        System.out.println(username);
        System.out.println(phone);
    }

    @DataProvider
    public Object[][] getDataFromExcel() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("testing");
        int rowNum = sheet.getLastRowNum();
        int columnNum = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowNum][columnNum];
        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }

    @Test(dataProvider = "getDataFromExcel2")
    public void testDataProvider2(Map<String, String> map) {
        System.out.println(map.get("username"));
        System.out.println(map.get("phone"));
    }

    @DataProvider
    public Object[] getDataFromExcel2() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("testing");
        int rowNum = sheet.getLastRowNum();
        int columnNum = sheet.getRow(0).getLastCellNum();
        Object[] data = new Object[rowNum];
        Map<String, String> map;
        for (int i = 1; i <= rowNum; i++) {
            map = new HashMap<>();
            for (int j = 0; j < columnNum; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                data[i-1] = map;
            }
        }
        return data;
    }
}
