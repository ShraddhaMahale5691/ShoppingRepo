package com.flip.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flip.qa.Pages.FlipLogin;
import com.flip.qa.Pages.HomePage;
import com.flip.qa.Utils.ListnersPage;
import com.flip.qa.Utils.TestUtils;
import com.flip.qa.Utils.log;
import com.flip.qa.base.FlipTestBase;

public class FlipHomePageTest extends FlipTestBase{
	FlipLogin loginobj;
	TestUtils testutilobj;
	ListnersPage listner;
	HomePage homepage;
	
	public FlipHomePageTest()
	{
		super();
	}
	
	
@BeforeMethod
public void Init() 
{
	init();
	loginobj=new FlipLogin();
    homepage=loginobj.Login(prop.getProperty("User"),prop.getProperty("Pwd"));
}

@Test
public void verifyHomepagetitleTest() throws InterruptedException
{
	log.info("Home Title Logs"+Thread.currentThread().getId());
	Thread.sleep(2000);
	String title=homepage.verifyHomePageTitle();
	//Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
}


@AfterMethod
public void close()
{
	closebrowser();
}
}
