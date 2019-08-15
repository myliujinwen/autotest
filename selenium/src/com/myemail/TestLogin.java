package com.myemail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	public void setUp(){
		driver=new ChromeDriver();
		baseUrl = "http://www.126.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@Test
	public void testCase() throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.id("switchAccountLogin")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='loginDiv']/iframe")));
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("chengzhangour");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("ljw901121");
		driver.findElement(By.id("dologin")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.id("spnUid")).getText();
		Assert.assertEquals(text, "chengzhangour@126.com");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
