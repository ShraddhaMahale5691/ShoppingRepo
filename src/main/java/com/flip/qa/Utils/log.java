package com.flip.qa.Utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import org.apache.log4j.BasicConfigurator;
public class log implements IReporter {
	
private static Logger logger=Logger.getLogger(log.class.getName());


public static void info(String msg)
{
	logger.info(msg);
}
public static void debug(String msg)
{
	logger.debug(msg);
}
public static void error(String msg)
{
	logger.error(msg, null);
}
public static void warn(String msg)
{
	logger.warn(msg);
}

public static void fatal(String msg)
{
	logger.fatal(msg);
}
@Override
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
	// TODO Auto-generated method stub
	
}
}
