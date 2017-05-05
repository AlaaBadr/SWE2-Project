package com.edugame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	public static boolean registerTest(WebDriver driver)
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
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);// 1 minute 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:3000/login";
		
		return actual.equals(expected);
	}
	
	public static boolean loginTest(WebDriver driver)
	{
		driver.get("http://localhost:3000/login");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		
		driver.findElement(By.id("username")).sendKeys("AlaaAtef");
		driver.findElement(By.id("password")).sendKeys("12345678");
		
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);// 1 minute 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("course")));
		
		driver.findElement(By.id("course")).click();
		
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:3000/home";
		
		return actual.equals(expected);
	}
	
	public static boolean addCourseTest(WebDriver driver)
	{
		loginTest(driver);
		
		driver.findElement(By.linkText("Add course")).sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("courseName")));
		
		driver.findElement(By.id("courseName")).sendKeys("Science");
		driver.findElement(By.id("description")).sendKeys("Scientific facts about the world.");
		
		driver.findElement(By.id("add")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);// 1 minute 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("gamers")));
		
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:3000/home";
		
		return actual.equals(expected);
	}
	
	public static boolean showAllCoursesTest(WebDriver driver)
	{
		loginTest(driver);
		
		driver.findElement(By.linkText("Courses")).sendKeys(Keys.ENTER);
		
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:3000/courses";
		
		return actual.equals(expected);
	}
	
	public static boolean addGameTest(WebDriver driver) throws InterruptedException
	{		
		addCourseTest(driver);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);// 1 minute 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("course")));
		
		driver.findElement(By.linkText("Add Game")).sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gameName")));
		
		driver.findElement(By.id("gameName")).sendKeys("Facts");
		driver.findElement(By.id("description")).sendKeys("Learn some scientifical facts.");
		driver.findElement(By.id("levelno")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		new Select(driver.findElement(By.id("courses"))).selectByVisibleText("Science");
		driver.findElement(By.id("TorF")).click();
		driver.findElement(By.id("TorF")).click();
		
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.id("levelName")).sendKeys("Earth");
		driver.findElement(By.id("question")).sendKeys("Is Earth flat?");
		driver.findElement(By.id("False")).click();
		
		driver.findElement(By.id("next")).click();
		
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("levelName")).clear();
		driver.findElement(By.id("question")).clear();
		driver.findElement(By.id("levelName")).sendKeys("Sun");
		driver.findElement(By.id("question")).sendKeys("Sun is bigger than Earth?");
		driver.findElement(By.id("True")).click();
		
		driver.findElement(By.id("next")).click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, 60);// 1 minute 
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("gamers")));
		
		String actual = driver.getCurrentUrl();
		String expected = "http://localhost:3000/home";
		
		return actual.equals(expected);
	}
	
	public static boolean showAchievementsTest(WebDriver driver)
	{
		driver.get("http://localhost:3000/login");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		
		driver.findElement(By.id("username")).sendKeys("KarimEhab");
		driver.findElement(By.id("password")).sendKeys("12345678");
		
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);// 1 minute 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("course")));
		
		WebElement e = driver.findElement(By.xpath("//div[contains(@class, 'ach-list')]/h1"));
		if(e != null)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
//		if(registerTest(driver))
//			System.out.println("Register Test PASSED!");
//		else
//			System.out.println("Register Test FAILED!");
		
//		if(loginTest(driver))
//			System.out.println("Login Test PASSED!");
//		else
//			System.out.println("Login Test FAILED!");
		
//		if(addCourseTest(driver))
//			System.out.println("Add Course Test PASSED!");
//		else
//			System.out.println("Add Course Test FAILED!");
		
//		if(showAllCoursesTest(driver))
//			System.out.println("Show All Courses Test PASSED!");
//		else
//			System.out.println("Show All Courses Test FAILED!");
		
//		if(addGameTest(driver))
//			System.out.println("Add Game Test PASSED!");
//		else
//			System.out.println("Add Game Test FAILED!");
		
//		if(showAchievementsTest(driver))
//			System.out.println("Show Achievements Test PASSED!");
//		else
//			System.out.println("Show Achievements Test FAILED!");
	}
}