package com.flip.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flip.qa.base.FlipTestBase;

public class HomePage extends FlipTestBase {


	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=".//div[contains(text(),'Mixer Juicer Grinders')]")
	WebElement mixer;
	
	@FindBy(xpath=".//div[@class='xtXmba' and text()='Grocery']")
	WebElement grosery;
	
	@FindBy(xpath=".//input[@name='pincode']")
	WebElement pin;
	
	@FindBy(xpath=".//span[contains(text(),'Login')]")
	WebElement loggin;
	

	@FindBy(xpath=".//div[contains(text(),'Shree Akshara Premium  Sona Masoori Rice (Steam)')]")
	WebElement specificdry;	
		

	@FindBy(xpath=".//div[@class='InyRMC _3Il5oO']//div[@class='_1psGvi SLyWEo']//div[contains(text(),'Staples')]")
	WebElement staple;
	
	@FindBy(xpath=".//div[@class='_3XS_gI _7qr1OC']//a[@class='_6WOcW9'][5]")
	WebElement dryfruit;
	
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public Staples verifygroserytabisclickable()
	{
		grosery.click();
		return new Staples();
	}
	public Staples verifyStaplesVerifyisclickable() throws InterruptedException
	{
		Thread.sleep(3000);
        Actions action=new Actions(driver);
		action.moveToElement(staple).build().perform();
		Thread.sleep(3000);
		action.moveToElement(specificdry).click().build().perform();
		return new Staples();
		
	}
	

	
	
}
