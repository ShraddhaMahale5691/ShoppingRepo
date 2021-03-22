package com.flip.qa.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	
	int counter=0;
	int retrylimit=2;
	TestUtils tu=new TestUtils();
	

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(counter<retrylimit)
		{
			counter++;
			return true;
		}
	    
		return false;
	}

}
