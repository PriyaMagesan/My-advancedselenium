package TestNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {

	 @BeforeTest
		private void Sample() {
	        System.out.println("before test is executed");	
		}
		@AfterTest
		private void sample1() {
	        System.out.println("after test is executed");	
		}
		@BeforeMethod
		private void Sample2() {
	        System.out.println("before method is executed");	
		}
		@AfterMethod
		private void Sample3() {
	        System.out.println("after method is executed");	
		}
		@Test
		private void Sample4() {
	        System.out.println("@test is executed");	
		}
		
		@Test
		private void Sample5() {
	        System.out.println("@test is executed");
		}
	}

