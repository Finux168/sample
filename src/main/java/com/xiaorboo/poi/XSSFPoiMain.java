package com.xiaorboo.poi;

import java.io.FileOutputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * .xlsx(excel 2007以上的版本)的excel文件操作
 *
 * @Author: fgd
 * @Date: 2019-10-24
 */
public class XSSFPoiMain {
    private static final int NUM_OF_ROWS = 7;
    private static final Random RNG = new Random();

    public static void main(String[] args) throws Exception{
        //写入少量数据
//        writeXlsxWithBitsofData();
        //写入大量数据
//        writeXlsxWithBigData();
    }

    /**
     *
     * 向xlsx文件中写入少量数据
     *
     */
    public static void writeXlsxWithBitsofData() throws Exception{
        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheet = wb.createSheet("Sheet1");

            XSSFRow row = sheet.createRow(0);
            row.createCell(0);
            row.createCell(1).setCellValue("Bars");
            row.createCell(2).setCellValue("Lines");

            XSSFCell cell;
            for (int r = 1; r < NUM_OF_ROWS; r++) {
                row = sheet.createRow(r);
                cell = row.createCell(0);
                cell.setCellValue("C" + r);
                cell = row.createCell(1);
                cell.setCellValue(RNG.nextDouble());
                cell = row.createCell(2);
                cell.setCellValue(RNG.nextDouble() * 10);
            }
            try (FileOutputStream fileOut = new FileOutputStream("Temp.xlsx")) {
                wb.write(fileOut);
            }
        }
    }

    public static void writeXlsxWithBigData() throws Exception {
        //官方推荐写入大量数据需要使用 SXSSFWorkbook ,避免内存溢出
        //Please note that there are still things that still may consume a large amount of memory based on which features you are using,
        // e.g. merged regions,comments, ... are still only stored in memory and thus may require a lot of memory if used extensively.
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        Sheet sh = wb.createSheet();
        for (int rownum = 0; rownum < 1000; rownum++) {
            Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < 10; cellnum++) {
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }
        }
        try (FileOutputStream fileOut = new FileOutputStream("Temp.xlsx")) {
            wb.write(fileOut);
        }
    }

    /**
     * 读取少量数据的excel
     */
    public static void readXlsxWithBitsofData(){
        //使用 WorkbookFactory.create() 创建合适的 HSSFWorkbook 或者 XSSFWorkbook.然后读取即可
    }

    /**
     * 读取大量数据的excel
     */
    public static void readXlsxWithBigData(){
        //为了避免内存溢出,官方建议将 excel 转成 csv 再读取.
    }
}
