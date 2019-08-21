package com.onlineretail.qa.pages;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.lang.exception.ExceptionUtils;
import com.onlineretail.qa.logreports.LogReports;
import com.onlineretail.qa.utils.JiraPolicy;
import com.onlineretail.qa.utils.JiraServiceProvider;

public class ListenerTest implements ITestListener{
	LogReports log=new LogReports();
	public void onTestStart(ITestResult result) {
		log.info(result.getName()+" test case started");			
	}
	public void onTestSuccess(ITestResult result) {
		log.info("The name of the testcase passed is :"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady = jiraPolicy.logTicketReady();
		if (isTicketReady) {
			
			System.out.println("is ticket ready for JIRA: " + isTicketReady);
			JiraServiceProvider jiraSp = new JiraServiceProvider("https://automatetestcase.atlassian.net","annesasi1803@gmail.com", "OvRegiFkcxQlsCDKb0o43253", "TES");
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + "got failed due to some assertion or exception";
			String issueDescription = result.getThrowable().getMessage() + "\n";
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

			jiraSp.createJiraTicket("Bug", issueSummary, issueDescription, "Anne");
		}
		log.info("The name of the testcase failed is :"+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		log.info("The name of the testcase Skipped is :"+result.getName());	
	}
	 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
