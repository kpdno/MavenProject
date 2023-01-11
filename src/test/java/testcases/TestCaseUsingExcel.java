package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utalities.ExcelUtalities;

public class TestCaseUsingExcel {

	
	@Test(dataProvider = "MyData")
	public void test1(){
		//test to check the same thing with multiple data set
	}
	
	
	@DataProvider
	public Object[][] MyData(){
		return ExcelUtalities.getDatafromtable("LoginTable", "Users", "src\\data\\MyData.xlxs");
	}
	
}
