package com.flip.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.flip.qa.Utils.TestUtils;
import com.flip.qa.base.FlipTestBase;

public class FlipLogin extends FlipTestBase {
	

	public FlipLogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//div[@class='IiD88i _351hSN']//input[@class='_2IX_2- VJZDxU']")
	WebElement Userid;
	
	@FindBy(xpath=".//div[@class='IiD88i _351hSN']//input[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement Pwd;
	
	@FindBy(xpath=".//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement loginbutton;
	
	
	
	public String loginPageValidation()
	{
		return driver.getTitle();
	}
	
	public HomePage Login(String uid,String Pass)
	{
		Userid.sendKeys(uid);
		Pwd.sendKeys(Pass);
		loginbutton.click();
		return new HomePage();
		
		
	}
	
	
	
	
	
	
}
