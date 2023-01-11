package lesson26;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream readFile = new FileInputStream("src\\test\\java\\testdata\\MyData.XLSX");
		
		XSSFWorkbook workbook = new XSSFWorkbook(readFile);


		System.out.println("Sheet number: " + workbook.getNumberOfSheets());
		System.out.println(workbook.getSheetIndex("Users"));
		System.out.println(workbook.getSheetName(1));
		
		
		XSSFSheet sheet1 = workbook.getSheet("Users");
		
		Cell cell = sheet1.getRow(1).getCell(3);
		String data = cell.getStringCellValue();
		
		System.out.println(data);
		
	}

}
