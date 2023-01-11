package lesson26;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream readFile = new FileInputStream("src\\test\\java\\testdata\\MyData.XLSX");
		
		XSSFWorkbook workbook = new XSSFWorkbook(readFile);
//		XSSFSheet sheet = workbook.getSheet("Users");
		XSSFSheet sheet = workbook.getSheetAt(1);
		
		Iterator <Row> rowIterator = sheet.rowIterator();
		
		Row row;
		Cell cell;
		
		while(rowIterator.hasNext()) {
			row = rowIterator.next();
			
			
			Iterator <Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				cell = cellIterator.next();
				
				String data = cell.getStringCellValue();
				System.out.println(data);
				
			}
			
		}
		

	}

}
