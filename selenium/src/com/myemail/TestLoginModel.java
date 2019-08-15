package com.myemail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginModel {
	WebDriver driver;
	String baseUrl;
	@BeforeMethod
	public void setUp(){
		driver = new ChromeDriver();
		baseUrl="http://www.126.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}
	
	@Test
	public void login() throws InterruptedException {
		String userName="chengzhangour";
		driver.get(baseUrl);
		Login.login(driver, userName, "ljw901121");

		String text=driver.findElement(By.id("spnUid")).getText();
		Assert.assertEquals(text,userName+"@126.com" );
		
		System.out.println(text+"------------"+userName+"@126.com");
		Login.logout(driver);
	}
	
	@AfterMethod
	public void setDown(){
		driver.quit();
	}

}
