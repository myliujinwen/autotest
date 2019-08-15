package com.myemail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSearch {
	private WebDriver driver;
	private String baseUrl;
	@BeforeMethod
	public void setUp(){
		driver=new ChromeDriver();
		baseUrl="http://www.126.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testSearch() throws Exception{
		driver.get(baseUrl);
		Thread.sleep(1000);
		String userName="chengzhangour";
		String password="ljw901121";
		Login.login(driver, userName, password);
		Thread.sleep(2000);
		
		//ËÑË÷
		WebElement el=driver.findElement(By.xpath("//input[@class='nui-ipt-input' and @type='text']"));
		el.sendKeys("Ð¡Ã÷");
		el.sendKeys(Keys.ENTER);
		
		//¶ÏÑÔËÑË÷±êÇ©Ò³Ãæ
		String text = driver.findElement(By.xpath("//h1[@class='nui-title-text']")).getText();
		
		Assert.assertEquals(text, "ËÑË÷½á¹û");
	}
	
	@AfterMethod
	public void setDown(){
		driver.quit();
	}

}
