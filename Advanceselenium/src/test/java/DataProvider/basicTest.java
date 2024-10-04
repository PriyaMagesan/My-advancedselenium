package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class basicTest {
	//Data provider is used to run the same script with different type of data
		
		
		@Test(dataProvider="learn")
	     public void getdata(String source,String destination) {
	    	 
	    	 System.out.println("flight booked from "+source+" to "+ destination);

		}
		
		
		@DataProvider
		public Object[][] learn() throws Throwable {
			Object[][] objarr=new Object[3][2];
			objarr[0][0]="Kashmir";
			objarr[0][1]="Kanyakumari";
			
			objarr[1][0]="Karnataka";
			objarr[1][1]="Karnataka";
			
			objarr[2][0]="canada";
			objarr[2][1]="japan";
			
			
			return objarr;
			
			
		}		
			

}
