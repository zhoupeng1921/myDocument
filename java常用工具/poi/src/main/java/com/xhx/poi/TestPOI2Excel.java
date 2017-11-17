package com.xhx.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestPOI2Excel {
    public static void testWrite03Excel() throws Exception {
        //1.创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.创建工作表
        HSSFSheet sheet = workbook.createSheet("sheet1");
        //3.创建行 创建第三行
        HSSFRow row = sheet.createRow(4);
        //4.创建单元格 创建第三行第三列
        HSSFCell cell = row.createCell(4);
        cell.setCellValue("hello_world");

        //输出到硬盘
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\a.xls");
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();
    }
    public static void testWrite07Excel() throws Exception {
        //1.创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //2.创建工作表
        XSSFSheet sheet = workbook.createSheet("sheet1");
        //3.创建行 创建第三行
        XSSFRow row = sheet.createRow(4);
        //4.创建单元格 创建第三行第三列
        XSSFCell cell = row.createCell(4);
        cell.setCellValue("hello_world");

        //输出到硬盘
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\a.xlsx");
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();
    }

    public static void testRead03Excel() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("E:\\a.xls");
        //1.读取工作簿
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        //2.读取工作表
        HSSFSheet sheet = workbook.getSheetAt(0);//也可以用name
        //3.读取行 读取第4行
        HSSFRow row = sheet.getRow(4);
        //4.读取单元格 读取第4行第4列
        HSSFCell cell = row.getCell(4);
        System.out.println("第4行第4列单元格内容为："+cell.getStringCellValue());

        workbook.close();
    }
    public static void testRead07Excel() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("E:\\a.xlsx");
        //1.读取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        //2.读取工作表
        XSSFSheet sheet = workbook.getSheetAt(0);//也可以用name
        //3.读取行 读取第4行
        XSSFRow row = sheet.getRow(4);
        //4.读取单元格 读取第4行第4列
        XSSFCell cell = row.getCell(4);
        System.out.println("第4行第4列单元格内容为："+cell.getStringCellValue());

        workbook.close();
    }
    public static void testRead03And07Excel() throws Exception {
        String fileName = "E:\\a.xls";

        if(fileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){//判断是否是excel文档
            boolean is07Excel = fileName.matches("^.+\\.(?i)(xlsx)$");
            FileInputStream fileInputStream = new FileInputStream(fileName);
            //1.读取工作簿
            Workbook workbook =is07Excel? new XSSFWorkbook(fileInputStream): new HSSFWorkbook(fileInputStream);
            //2.读取工作表
            Sheet sheet = workbook.getSheetAt(0);//也可以用name
            //3.读取行 读取第4行
            Row row = sheet.getRow(4);
            //4.读取单元格 读取第4行第4列
            Cell cell = row.getCell(4);
            System.out.println("第4行第4列单元格内容为："+cell.getStringCellValue());

            workbook.close();
        }

    }

    public static void testExcelStyle() throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        //1.1创建合并单元格对象
        CellRangeAddress cellRangeAddress = new CellRangeAddress(2, 2, 2, 4);



        //1.2创建合并单元格样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中


        //1.3创建字体
        HSSFFont font = workbook.createFont();
        font.setBold(true);
       // font.setFontHeight((short)16); //1/20 a point
        font.setFontHeightInPoints((short)16);
        //加载字体
        cellStyle.setFont(font);


        //单元格背景
        //设置背景填充模式
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //背景色
        cellStyle.setFillBackgroundColor((short) 10);

        HSSFSheet sheet = workbook.createSheet("hello world");
        //合并单元格
        sheet.addMergedRegion(cellRangeAddress);

        HSSFRow row = sheet.createRow(2);
        HSSFCell cell = row.createCell(2);
        cell.setCellValue("成功合并");
        cell.setCellStyle(cellStyle);

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\a.xls");
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();

    }

    public static void main(String[] args) {
        try {
           // testWrite03Excel();
          //  testRead03Excel();
          //  testWrite07Excel();
          //  testRead07Excel();
          //  testRead03And07Excel();
            testExcelStyle();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
