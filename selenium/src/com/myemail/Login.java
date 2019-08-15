package com.myemail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	public static void login(WebDriver driver,String userName,String passWord) throws InterruptedException{
		driver.findElement(By.id("switchAccountLogin")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='loginDiv']/iframe")));
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(passWord);
		driver.findElement(By.id("dologin")).click();
		Thread.sleep(2000);

	}
	
	public static void logout(WebDriver driver){
		driver.findElement(By.linkText("ÍË³ö"));
	}

}
