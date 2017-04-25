/*package com.edugame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	public static void registerTest(WebDriver driver)
	{
		driver.get("http://localhost:3000/register");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
		
		driver.findElement(By.id("fullname")).sendKeys("Haya Ahmed");
		driver.findElement(By.id("username")).sendKeys("Hayaa");
		driver.findElement(By.id("password")).sendKeys("12345678");
		driver.findElement(By.id("email")).sendKeys("haya@haya.com");
		driver.findElement(By.id("age")).sendKeys("18");
		driver.findElement(By.id("female")).click();
		driver.findElement(By.id("female")).click();
		driver.findElement(By.id("student")).click();
		driver.findElement(By.id("student")).click();
		
		driver.findElement(By.id("register")).click();
	}
	
	public static void loginTest(WebDriver driver)
	{
		driver.get("http://localhost:3000/login");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		
		driver.findElement(By.id("usernameLogin")).sendKeys("AlaaAtef");
		driver.findElement(By.id("passwordLogin")).sendKeys("12345678");
		
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);// 1 minute 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("course")));
		
		driver.findElement(By.id("course")).click();
	}
	
	public static void addCourseTest(WebDriver driver)
	{
		driver.get("http://localhost:3000/addcourse");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("courseName")));
		
		driver.findElement(By.id("courseName")).sendKeys("Btates");
		driver.findElement(By.id("description")).sendKeys("kayf t7amar elbtates b tareeqa e7trafya.");
		
		driver.findElement(By.id("add")).click();
	}
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\AlaaPrograms\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//registerTest(driver);
		//loginTest(driver);
		//addCourseTest(driver);
	}
}*/