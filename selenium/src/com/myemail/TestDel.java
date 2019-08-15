package com.myemail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDel {
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
		
		List<WebElement> els = driver.findElements(By.className("oz0"));
		for(WebElement el: els){
			if(el.getText().equals(" ’ –≈")){
				el.click();
				Thread.sleep(1000);
			}
		}
	}

	@AfterMethod
	public void setDown(){
		//driver.quit();
	}

}
