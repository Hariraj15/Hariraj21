package org.test.ExcelIntegration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {
	static String name;
	public static String getData(int rowno,int colno) throws Throwable {
		File loc = new File("C:\\Users\\asus\\eclipse-Hari\\ExcelIntegration\\Sheet\\ExcelTask.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook book = new XSSFWorkbook(stream);
		Sheet s = book.getSheet("Datas");
		Row r = s.getRow(rowno);
		Cell c =r.getCell(colno);
		int ctype = c.getCellType();
		name="";
		if(ctype==1) {
			name= c.getStringCellValue();
			System.out.println(name);
			
		}
		else if(ctype==0) {
			if(DateUtil.isCellDateFormatted(c));
			Date dCell = c.getDateCellValue();
			SimpleDateFormat fo =new SimpleDateFormat("yy--dd--mm");
			name = fo.format(dCell);
			System.out.println(name);
		 
			
		}
		else {
			double d = c.getNumericCellValue();
			long l =(long)d;
			name=String.valueOf(l);
			System.out.println(name);
		}
		return name;
        
		
		
	}
	public static void main(String[] args) throws Throwable {
		getData(1,1);
		
	}

}
