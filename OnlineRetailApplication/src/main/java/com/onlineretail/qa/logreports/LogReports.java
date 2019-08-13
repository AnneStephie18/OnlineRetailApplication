package com.onlineretail.qa.logreports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.onlineretail.qa.constants.Constants;

public class LogReports {
	Logger logger = null;

	public LogReports() {
	getlogger();
	logger = Logger.getLogger(LogReports.class.getName());
	}

	public void getlogger() {
	PropertyConfigurator.configure(Constants.PROJECT_LOG_PATH);
	}

	public void info(String message) {
	logger.info(message);
	}
}
