package com.onlineretail.qa.pages;

import org.testng.ITestResult;

import com.onlineretail.qa.utils.IRetryAnalyzer;

public class RetryAnalyzer implements IRetryAnalyzer{
	int counter = 0;
	int retryLimit = 4;
	

	public boolean retry(ITestResult result) {

		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}
}
