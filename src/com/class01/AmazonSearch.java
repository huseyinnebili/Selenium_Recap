 package com.class01;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	static WebDriver driver;

	public static void brokenlinks() throws MalformedURLException {

		List<WebElement> list_of_links = driver.findElements(By.tagName("a"));

		for (WebElement list_of_link : list_of_links) {

			String url = list_of_link.getAttribute("href");

			try {
				URL link = new URL(url);

				HttpURLConnection http_connect = (HttpURLConnection) link.openConnection();

				http_connect.connect();

				int status_code = http_connect.getResponseCode();

				if (status_code >= 400) {

					System.out.println(url + " is broken link.");
				}

				else {

					System.out.println(url + " is valid link.");
				}
			} catch (Exception e) {

				e.printStackTrace();

			}
		}

	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		
		driver.navigate().to("https://www.amazon.com/");
		
		Thread.sleep(1000);
		
		driver.manage().window().maximize();
		
		//brokenlinks();
		
		System.out.println("The TITLE of the Amazon.com = "+driver.getTitle());
		
		System.out.println("The Current URL of the Amazon.com = "+driver.getCurrentUrl());
		
		System.out.println("The window_ID of the Amazon.com = "+driver.getWindowHandle());
		
		Thread.sleep(2000);
		
		
		String exp_title="Amazon.com. Spend less. Smile more.";
		String actual_title=driver.getTitle();
		
		if(exp_title.equalsIgnoreCase(actual_title)) {
			
			System.out.println("Test passed!...");
		}
		else {
			
			System.out.println("Test failed!..");
		}
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("clothes");
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(1000);
		
		
		//clear the search box trough cssSelector
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).clear();
		
		Thread.sleep(1000);
		
		//send an element to search box trough cssSelector
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("shoes");
		
		Thread.sleep(1000);
		
		// click the search box trough cssSelector
	    // driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		
		//input#nav-search-submit-button => means any inputs having the id called 'nav-search-submit-button'.
		//#nav-search-submit-button => means any elements having the id called 'nav-search-submit-button'. 
		
		//div.nav-right>div>span => means any divs having the class called 'nav-right' and inside of it div and inside of it again span.
		//.nav-right>div>span => means any elements  having the class called 'nav-right' and inside of it div and inside of it again span.
		
		Thread.sleep(1000);
		
		
		
//   one forward slash means direct child element.  //*[@id='a-page']/div =>it will return only children of a-page element(7)
//   two forward slashes mean direct or indirect child elements. //*[@id='a-page']//div =>it will return all children of a-page element(893)
		
		driver.quit();
	}

}
