package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadmultipledataTest {
	//@Test
	public static void main() throws EncryptedDocumentException, IOException {

		FileInputStream file=new FileInputStream("./src/test/resources/excelReading.xlsx");
		
		Workbook workbook = WorkbookFactory.create(file);
		
		Sheet sheet1 = workbook.getSheet("Sheet1");
		int lastRowNum = sheet1.getLastRowNum();
		System.out.println(lastRowNum);
		
		
	}

}
