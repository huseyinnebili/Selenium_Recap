package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RedfinFirefoxDriver {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		String exp_url = "https://www.redfin.com/";

		driver.navigate().to(exp_url);

		String cur_url = driver.getCurrentUrl();

		if (cur_url.equalsIgnoreCase(exp_url)) {

			System.out.println("Test passed!...");
		}

		else {

			System.out.println("Test failed!...");
		}

		System.out.println("The current url = " + cur_url);

		System.out.println("The title of the web page = " + driver.getTitle());

		System.out.println("The ID of the web page = " + driver.getWindowHandle());

		String exp_title = "Real Estate, Homes for Sale, MLS Listings, Agents | Redfin";

		String act_title = driver.getTitle();

		if (act_title.equalsIgnoreCase(exp_title)) {

			System.out.println("Test passed!...");
		}

		else {

			System.out.println("Test failed!...");
		}
		
		Thread.sleep(2000);

		driver.quit();
	}

}
