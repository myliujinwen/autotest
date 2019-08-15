package com.myemail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestLoginParameter {
	WebDriver driver;
	String baseUrl;
	@BeforeMethod
	public void setUp(){
		driver = new ChromeDriver();
		baseUrl="http://www.126.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@DataProvider(name="user")
	public Object[][] Users(){
		return new Object[][]{
			{"","","«Î ‰»Î’ ∫≈"},
			{"chengzhangour","","«Î ‰»Î√‹¬Î"},
			{"","123456","«Î ‰»Î’ ∫≈"},
			{"error1","error1","’ ∫≈ªÚ√‹¬Î¥ÌŒÛ"},
		};
	}
	
	@Test(dataProvider="user")
	public void testCase(String username,String passWord,String expectText) throws InterruptedException{
		driver.get(baseUrl);
		Thread.sleep(1000);
		Login.login(driver, username, passWord);
		Thread.sleep(1000);
		String text=driver.findElement(By.className("ferrorhead")).getText();
		System.out.println(text+"------------"+expectText);
		Assert.assertEquals(text,expectText);	
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
