package com.class01;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class LaunchGoogle {
	
	static WebDriver driver;
	
	public static void takescreenshot(String folder_name,String file_name) throws IOException {
		
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("C:\\Users\\husey\\eclipse-workspace\\Selenium_Recap\\Screenshots\\"+folder_name+"/"+file_name+".png"));
		
		
		
		
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\Selenium_Recap\\drivers\\chromedriver.exe");

		 driver = new ChromeDriver();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		System.setProperty("webdriver.gecko.driver",
//				"C:\\Users\\husey\\eclipse-workspace\\Selenium_Recap\\drivers\\geckodriver.exe");
//
//		WebDriver driver = new FirefoxDriver();

		driver.navigate().to("https://www.signal-telecom.com/");

		Thread.sleep(2000);

		String actualURL = driver.getCurrentUrl();

		String exp_URL = "https://www.signal-telecom.com/";

		if (actualURL.equalsIgnoreCase(exp_URL)) {

			System.out.println("The title of the web page = " + driver.getTitle());
		} else {

			System.out.println("It is wrong web page!...");

		}
		System.out.println("======The First Page Info========");

		System.out.println("The TITLE of first page = " + driver.getTitle());
		System.out.println("The ID of the first page = " + driver.getWindowHandle());
		System.out.println("The Current URL the first page = " + driver.getCurrentUrl());

		Thread.sleep(2000);

		System.out.println("======The Second Page Info========");

		driver.navigate().to("https://www.geeksforgeeks.org/");

		Thread.sleep(2000);

		driver.manage().window().maximize();

		Thread.sleep(3000);

		driver.manage().window().minimize();

		Thread.sleep(3000);

		System.out.println("The current URL of second page = " + driver.getCurrentUrl());

		System.out.println("The current TITLE of second page = " + driver.getTitle());

		System.out.println("The current window ID of second page = " + driver.getWindowHandle());

		Thread.sleep(2000);

		driver.navigate().back();

		Thread.sleep(1000);

		driver.navigate().refresh();

		Thread.sleep(2000);

		//driver.close();

		driver.navigate().to("https://demoqa.com/text-box");
		
		Thread.sleep(2000);

		driver.findElement(By.id("userName")).sendKeys("abuzer123");

		Thread.sleep(1000);

		driver.findElement(By.id("userEmail")).sendKeys("abzr123@gmail.com");

		Thread.sleep(1000);

		driver.findElement(By.id("currentAddress")).sendKeys("NJ");

		Thread.sleep(1000);

		driver.findElement(By.id("permanentAddress")).sendKeys("NJasda");

		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,450)");
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id='userForm']/div[5]/div/button")));

		Thread.sleep(3000);
		
		takescreenshot("Toolsqa", "LaunchToolsqa");
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#userName")).sendKeys("AbzrKad123");
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("abzr123@gmail.com");
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Nj/Wayne");
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("NJ/Wayne/Courter");
		
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,450)");
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click()",driver.findElement(By.cssSelector("#submit")));
		
		Thread.sleep(2000);
		
		takescreenshot("Toolsqa", "LaunchToolsqa_2");
		
		Thread.sleep(3000);

		 driver.quit();

	}

}
