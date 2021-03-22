package com.flip.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;



import com.flip.qa.Pages.FlipLogin;
import com.flip.qa.Pages.HomePage;
import com.flip.qa.Utils.ListnersPage;
import com.flip.qa.Utils.TestUtils;
import com.flip.qa.Utils.log;
import com.flip.qa.base.FlipTestBase;
import com.sun.tools.sjavac.Log;

@Listeners(com.flip.qa.Utils.ListnersPage.class)
public class FlipLoginTest extends FlipTestBase{

	FlipLogin loginobj;
	TestUtils testutilobj;
	ListnersPage listner;
	HomePage homepage;
	//BasicConfigurator.configure();

	public FlipLoginTest()
	{
		super();
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		///	Log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%Ready for setup%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		///	Log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%Ready for setup%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		init();
		testutilobj = new TestUtils();
		loginobj=new FlipLogin();


	}
	/*
	@DataProvider(name="Credentials")
	public Object[][] Logindetails()
	{
		return new Object[][] {{"amols.tayade@gmail.com","redhat123"}};
	}*/


	@DataProvider(name="Credentials")
	public Object[][] Logindetails() throws IOException
	{
		/*For taking data from here itself*/
		// return new Object[][] {{"amols.tayade@gmail.com","redhat123"}};

		/*for taking data from excel-Remember if there are two rows of user id i.e Amol and shraddha then two times the test case is executed*/
		Object[][] obj=TestUtils.ReadFile();
		return obj;
	}


	@Test
	public void LoginpageTitleTest()
	{
		log.info("Login Title Logs"+Thread.currentThread().getId());
		String title=loginobj.loginPageValidation();
		//Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}



	@Test(priority=1,dataProvider="Credentials")
	public void LoginTest(String u,String p)
	{
		log.info("Login Test Logs"+Thread.currentThread().getId());
		homepage=loginobj.Login(u, p);	
		//Assert.assertEquals(false,true);
	}

	@AfterMethod
	public void close()
	{
		closebrowser();
	}

}
