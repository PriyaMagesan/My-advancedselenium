package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelreading {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		///step1:- Path Representation
		FileInputStream m=new FileInputStream("./src/test/resources/excelReading.xlsx");
		
		///step2:-keeping the excel file in read mode
		Workbook book=WorkbookFactory.create(m);
		
		//step3:- get the control the Sheet-1
		Sheet sheet = book.getSheet("Sheet1");
		
//		//step4:- get the control the Row
//		Row row = sheet.getRow(1);
//		
//		//step5:- get the control the cell
//		Cell cell = row.getCell(3);
//		
//		//step6:- Reading cell value
//		String data=cell.getStringCellValue();
//		System.out.println(data);
//		
//		DataFormatter df=new DataFormatter();
//		String formatCellValue = df.formatCellValue(cell);
//		System.out.println(formatCellValue);
		
		
		//create a data inside the cell following process
		
		Row row1 = sheet.createRow(1);
		Cell cell1 = row1.createCell(6);
		cell1.setCellValue("mani");
		FileOutputStream n=new FileOutputStream("./src/test/resources/excelReading.xlsx");
		book.write(n);
		book.close();
		
	}

}



