package com.automationpractice.demos;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Adding java doc
 * @author TechCenture
 *
 */
public class TestNGDataProviderDemo {
	//STRING
//	@DataProvider(name="mortgageData")
//	public String[][] getData() {
//		String[][] data = new String[][] {
//			{"3.1","330000","15000","30"},
//			{"3.75","270000","12000","15"},
//			{"3.86","295000","35000","30"}
//		};
//		
//		return data;
//	}
	
	//Double
//	@DataProvider(name="mortgageData")
//	public Double[][] getData() {
//		Double[][] data = new Double[][] {
//			{3.1,330000.0,15000.0,30.0},
//			{3.75,270000.0,12000.0,15.0},
//			{3.86,295000.0,35000.0,30.0}
//		};
//		
//		return data;
//	}
	
	//mix type
	@DataProvider(name="mortgageData")
	public Object[][] getData() {
		Object[][] data = new Object[][] {
			{3.1,"330000",15000.0,30.0},
			{3.75,"270000",12000.0,15.0},
			{3.86,"295000",35000.0,30.0}
		};
		return data;
	}
	
	@Test(dataProvider = "mortgageData")
	public void calculateMortgageMonthlyPayment(Double ir, String tl, Double dp, Double l ) {
		System.out.println("Interest rate: "+ir );
		System.out.println("Total loan: "+tl );
		System.out.println("Downpayment: "+dp );
		System.out.println("Length: "+l );
	}
}
