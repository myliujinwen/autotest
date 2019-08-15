package com.mypro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.baidu.com");
		
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.id("su")).click();
		
		driver.close();
	}

}
