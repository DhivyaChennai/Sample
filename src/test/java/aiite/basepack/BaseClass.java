package com.aiite.basepack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;

	public static void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void browserLaunch(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}		
		driver.manage().window().maximize();
	}

	public static void loadURL(String url) { // parameter //argument - actual value which is passing during runtime
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static WebElement searchElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement searchElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath)); //
		return element;
	}
	
	public static String readCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static void screenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\Dell\\OneDrive - Enhops Solutions Pvt. Ltd\\Desktop\\Data\\SS.jpeg");
		FileHandler.copy(screenshotAs, file);
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static String getValue(String key) throws IOException {
		File file = new File(
				"C:\\Users\\Dell\\eclipse-workspace\\WebAutomation\\src\\test\\resources\\TestData\\Credentials.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);

		String property = prop.getProperty(key);
		return property;
	}

}
