package DataProvider;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderreaddatafromexcel {
	
	//@Test(dataProvider="excel")
	public Object[][] getdata() {
		
		Object[][] arr= new Object[10][5];
		return arr;
	
		
	}
	
		
    //@DataProvider
	public String excel() throws Throwable
	{
		FileInputStream fin=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\VtigerDatas.xlsx");
		Workbook book = WorkbookFactory.create(fin);
		org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Organization");
		int lastRowNum = sheet.getLastRowNum()+1; //35
		int lastCellNum = sheet.getRow(0).getLastCellNum(); 
		
		Object[][] arr= new Object[lastRowNum][lastCellNum];
		
    	for(int i=0;i<lastRowNum;i++)
		{
		for(int j=0;j<lastCellNum;j++)
		{
			arr[i][j]=sheet.getRow(i).getCell(j);
			
			String ar=arr[i][j].toString();

		}
		
		}
		return null;

	}
}
