package com.xiaorboo.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * .xlsx(excel 2007以上的版本)的excel文件操作
 *
 * 操作excel的类可以根据模板设计模式设计成一个模板类(类似spring中的jdbctemplate,restTemplate等)
 * 将创建workbook以及关闭workbook等公共操作封装到父类中,子类实现具体的业务逻辑即可.
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
        //读取少量数据
//        readXlsxWithBitsofData();
        //读取大量数据
        readXlsxWithBigData();
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
    public static void readXlsxWithBitsofData() throws Exception {
        //使用 WorkbookFactory.create() 创建合适的 HSSFWorkbook 或者 XSSFWorkbook.然后读取即可
        File xlsxFile = new File("Temp.xlsx");
        Workbook workbook = WorkbookFactory.create(xlsxFile);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            System.out.print("第"+row.getRowNum()+"行数据:");
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                Object obj;
                switch (cell.getCellType()) {
                    case BOOLEAN:
                        obj = cell.getBooleanCellValue();
                        break;
                    case ERROR:
                        obj = cell.getErrorCellValue();
                        break;
                    case NUMERIC:
                        obj = cell.getNumericCellValue();
                        break;
                    case STRING:
                        obj = cell.getStringCellValue();
                        break;
                    default:
                        obj = "";
                        break;
                }
                System.out.print(obj.toString()+"\t");
            }
            System.out.println();
        }
        workbook.close();
    }

    /**
     * 读取大量数据的excel
     */
    public static void readXlsxWithBigData() throws Exception {
        //为了避免内存溢出,官方建议将 excel 转成 csv 再读取.
    }
}
