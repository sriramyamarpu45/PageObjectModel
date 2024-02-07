package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT =30;
    static Workbook book;
    static Sheet sheet;

    public void switchToFrame()
    {
        driver.switchTo().frame("mainpanel");
    }
public static Object[][] getTestData(String sheetname)
{
    FileInputStream file = null;
    try {
       file = new FileInputStream("C:/Users/drn/IdeaProjects/PageObjectModel-CRM/src/main/java/com/crm/qa/testdata/dataProvider-CRM.xlsx");


    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    try {
        book = WorkbookFactory.create(file);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    sheet = book.getSheet(sheetname);
    Object[][] getDataFromExcel = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    for(int i=0;i<sheet.getLastRowNum();i++)
    {
        for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
        {
            getDataFromExcel[i][j]=sheet.getRow(i+1).getCell(j).toString();
        }
    }


    return getDataFromExcel;
}
}
