package com.flip.qa.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.helpers.Util;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.Status;
import com.flip.qa.base.FlipTestBase;
import com.relevantcodes.extentreports.LogStatus;

public class ListnersPage extends FlipTestBase implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("*********************************************************************************************");
		log.info("*******************************TestCase Started***********************************************");
		log.info("*********************************************************************************************");
		log.info("*******************************TestCase Started***********************************************");
		log.info("Testcase with name "+result.getMethod().getMethodName()+" started at time "+result.getStartMillis());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Testcase with name "+result.getMethod().getMethodName()+" Succeded at time "+result.getStartMillis());
	}

   @Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Testcase with name "+result.getMethod().getMethodName()+" failed at time "+result.getStartMillis());
		TestUtils.Takescrenshot(result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Testcase Skipped ********"+result.getMethod().getMethodName()+" at time "+result.getStartMillis());	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Testcase Failed but some passed percent ********"+result.getMethod().getMethodName()+" at time "+result.getStartMillis());
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("Testcase OnStart ********"+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Testcase OnFinish ********"+context.getName());
	}
	
		
	

}
