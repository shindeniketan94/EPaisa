package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Testreporter implements ITestListener
{

	public void onFinish(ITestContext arg0) 
	{
		System.out.println("Tests has Finished :" + arg0.getClass().getName());
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0)
	{
		System.out.println("Started Test case is :"+arg0.getName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		
		System.out.println("The name of the testcase passed is :"+arg0.getName());
	}
	
}

	
	
	
	