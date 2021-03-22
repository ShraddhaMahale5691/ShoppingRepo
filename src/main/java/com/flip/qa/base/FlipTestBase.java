package com.flip.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flip.qa.Utils.ListnersPage;

public class FlipTestBase {
public static WebDriver driver;
public static Properties prop;


public FlipTestBase() 
{
	
	 prop=new Properties();
	try {
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/flip/qa/config/config.properties");
		prop.load(ip);
		System.out.println(ip);
		
	} catch (FileNotFoundException e) {
				e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void init()
{
	String browsername=prop.getProperty("browser");
	if(browsername.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "D://Shraddha Wahini//chromedriver_win32//chromedriver.exe");
	 driver=new ChromeDriver();
	}
	 driver.get(prop.getProperty("url"));
	 driver.manage().window().maximize();
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 

	 
}

public void closebrowser()
{
	 driver.quit();
}
}