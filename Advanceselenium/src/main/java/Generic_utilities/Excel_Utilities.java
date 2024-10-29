package Generic_utilities;

import java.io.FileInputStream;
import java.util.Random;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel_Utilities {
	
	Random ran = new Random();
	int randNum = ran.nextInt(1000);
	
	
	
	
	public String getorganizationname(String sheetname,int rownum,int cellnum) throws Throwable
	{	
		FileInputStream finput=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\VtigerDatas.xlsx");
		Workbook book = WorkbookFactory.create(finput);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(rownum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);
		String stringCellValue = cell.getStringCellValue();
		return stringCellValue;
	}

	
	public String getphonenum(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream finput=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\VtigerDatas.xlsx");
		Workbook book = WorkbookFactory.create(finput);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(rownum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);
	
		DataFormatter data=new DataFormatter();
		String value = data.formatCellValue(cell);
		
		return value;		
	}
	
	
	public String getemailid(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream finput=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\VtigerDatas.xlsx");
		Workbook book = WorkbookFactory.create(finput);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(rownum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);
		String stringCellValue = cell.getStringCellValue();	
		
		return stringCellValue;
	}
	
	public String contactlastname(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream finput=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\VtigerDatas.xlsx");
		Workbook book = WorkbookFactory.create(finput);
		Sheet sheet = book.getSheet("Contacts");
		Row row = sheet.getRow(rownum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);
	
		String forcontactlastname = cell.getStringCellValue();
		
		return forcontactlastname;		
	}
	
	//Java_utilities javautils=new Java_utilities();
	//javautils.nextInt(1000);
	
	public String getproductname(String sheetname,int rownum,int cellnum) throws Throwable
	{
		
		
		FileInputStream finput = new FileInputStream("C:\\Users\\\\priya\\\\OneDrive\\\\Desktop\\\\Advanced Selenium\\\\VtigerDatas.xlsx");
		Workbook book = WorkbookFactory.create(finput);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);

		String prodname = cell.getStringCellValue()+randNum;
         book.close();
		return prodname;

	}
	
	public String getcampaignname(String sheetname,int rownum,int cellnum) throws Throwable {
          
		FileInputStream finput = new FileInputStream("C:\\Users\\\\priya\\\\OneDrive\\\\Desktop\\\\Advanced Selenium\\\\VtigerDatas.xlsx");
		Workbook book = WorkbookFactory.create(finput);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);

		String campaignname = cell.getStringCellValue()+randNum;
		return campaignname;
		
	}
	
}

