
package com.onlineretail.qa.constants;
/**
 * This class contains the path of the log ,properties file,implicit wait,page load timeout
 */
import java.io.File;

public class Constants {
    public final static String PROJECT_BASE_PATH= System.getProperty("user.dir");
	public final static long IMPLICIT_WAIT = 10;
	public final static long WEB_DRIVER_WAIT = 10;
	public final static String PROJECT_CHROMEPATH=PROJECT_BASE_PATH+File.separator+"lib"+File.separator+"chromedriver.exe";
	public final static String PROJECT_FIREFOXPATH=PROJECT_BASE_PATH+File.separator+"lib"+File.separator+"geckodriver.exe";
	public final static String PROJECT_INTERNETEXPLORERPATH=PROJECT_BASE_PATH+File.separator+"lib"+File.separator+"IEDriverServer.exe";
	public final static String PROJECT_CONFIGURATION_PATH = PROJECT_BASE_PATH+File.separator+"resources"+File.separator+"config.properties";
	public final static String PROJECT_LOG_PATH=PROJECT_BASE_PATH+File.separator+"resources"+File.separator+"log.properties";
	public final static String PROJECT_SEARCHTSHIRT_PRODUCT_PATH=PROJECT_BASE_PATH + File.separator+"resources"+File.separator+"locators"+File.separator+"searchtshirtproduct.properties";
	public final static String PROJECT_SELECTMAXI_PRODUCT_PATH=PROJECT_BASE_PATH + File.separator+"resources"+File.separator+"locators"+File.separator+"selectmaxiproduct.properties";
}

