package org.example.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.constants.FrameworkConstants;
import org.example.exceptions.ExcelFileIOException;
import org.example.exceptions.ExcelFileNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * This class is for processing Excel file
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class ExcelUtils {
    private ExcelUtils() {

    }
    /**
     * Read a sheet of Excel file into a list of map.
     * @param sheetName The sheet that are going to be read
     * @return List of Map with keys from the first line of the sheet
     */
    public static List<Map<String, String>> getTestDataAsMapList(String sheetName) {

        List<Map<String, String>> data = null;
        try (
                FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath());
                XSSFWorkbook workbook = new XSSFWorkbook(fis); ) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
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
        } catch (FileNotFoundException e) {
            throw new ExcelFileNotFoundException("testdata.xlsx is not found, please check the file path.", e);
        } catch (IOException e) {
            throw new ExcelFileIOException("There's an io exception with the testdata.xlsx.", e);
        }
        return data;
    }
}
