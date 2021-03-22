package com.flip.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.flip.qa.base.FlipTestBase;

public class TestUtils extends FlipTestBase {
	
	public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    static String SheetName= "Sheet1";
	public static String Filepath=System.getProperty("user.dir")+"/src/main/java/com/flip/qa/Testdata/FlipKartExcel.xlsx";
    static FileInputStream fileInputStream;
	 TakesScreenshot screenshot;

	 public static Object[][] ReadFile() throws IOException
	    {
	     fileInputStream= new FileInputStream(Filepath); //Excel sheet file location get mentioned here
	        workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
	        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
	     
	        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	        int ColNum= Row.getLastCellNum(); // get last ColNum 
	         
	        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
	         
	            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
	            {  
	                XSSFRow row= worksheet.getRow(i+1);
	                 
	                for (int j=0; j<ColNum; j++) //Loop work for colNum
	                 {
	                        XSSFCell cell= row.getCell(j);
	                        
	                            String value=formatter.formatCellValue(cell);
	                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	                  }
	              }
	                
	 
	        return Data;
	    }
	 
	 public static void Takescrenshot(String name)
	 {
		 File srcscreen	=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         try {
			FileUtils.copyFile(srcscreen, new File(System.getProperty("user.dir")+"/screenshots/"+name+"Failed"+ System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 
	 public static void scrolling()
	 {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,1000)", "");
		 
	 }
	 
	 public static void alertt()
	 {
		 Alert alt=driver.switchTo().alert();
		 alt.sendKeys("411057");
		alt.accept();
	 }
}