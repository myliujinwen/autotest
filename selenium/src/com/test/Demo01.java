package com.test;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo01 {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.youdao.com");
		Set<Cookie> coo=driver.manage().getCookies();	
		System.out.println(coo);
		
	}

}
