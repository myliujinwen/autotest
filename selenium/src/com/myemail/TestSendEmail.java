package com.myemail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestSendEmail {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	public void setUp(){
		driver=new ChromeDriver();
		baseUrl="http://www.126.com";
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void testSendEmail() throws Exception{
		driver.get(baseUrl);
		Thread.sleep(1000);
		String userName="chengzhangour";
		String password="ljw901121";
		Login.login(driver, userName, password);
		Thread.sleep(2000);
		List<WebElement> spans=driver.findElements(By.className("oz0"));
		
		for(WebElement span:spans){
			String text=span.getText();
			System.out.println(text);
			if(text.equals("写 信")){
				
				span.click();
				Thread.sleep(1000);
			}
		}
		//填写收件人
		WebElement el=driver.findElement(By.xpath("//*[@class='bz0']/div[2]/div/input"));
		el.sendKeys("chengzhangour@163.com");
		
		//填写主题
		driver.findElement(By.xpath("//input[@class='nui-ipt-input' and @type='text' and @maxlength='256']")).sendKeys("hellword");
		
		//切换表单
		driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
		
		//填写正文
		driver.findElement(By.className("nui-scroll")).sendKeys("好久不见");
		
		//返回默认表单
		driver.switchTo().defaultContent();
		//发送
		List<WebElement> spanss = driver.findElements(By.className("nui-btn-text"));
		for(WebElement span:spanss){
			String text=span.getText();
			if("发送".equals(text)){
				span.click();
				Thread.sleep(2000);
			}
		}
		
		String text = driver.findElement(By.className("tK1")).getText();
		System.out.println(text);
		Assert.assertEquals(text,"发送成功手机收发邮件更方便");
		Login.logout(driver);
	}
	
	@AfterMethod
	public void setDown(){
//		driver.quit();
	}

}
