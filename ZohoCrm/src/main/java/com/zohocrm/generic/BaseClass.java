package com.zohocrm.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() throws IOException {
		Reporter.log("open browser", true);
		driver = new ChromeDriver();
//		FileLib f = new FileLib();
//		String url = f.getPropertyData("url");
		driver.manage().window().maximize();
		driver.get("http://192.168.201.128:8080/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(url);
		

	}

	@AfterTest
	public void closeBrowser() {
		Reporter.log("closebrowser", true);
		driver.manage().window().minimize();
		driver.quit();

	}

	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login", true);
		FileLib f = new FileLib();
		String username = f.getPropertyData("username");
		String password = f.getPropertyData("password");
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("passWord")).sendKeys(password);
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();

	}

	@AfterMethod
	public void logout() {
		Reporter.log("logout", true);
	}
}
