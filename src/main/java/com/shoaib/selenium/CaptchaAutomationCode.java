package com.shoaib.selenium;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptchaAutomationCode {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.irctc.co.in/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='text-center col-xs-12']//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//div[@class='h_head1']//a[@id='loginText']")).click();
		
		//prompting user to enter captcha
		/*JoptionPane pops up a standard dialog box and showInputDialog prompts user for 
		some input. Once the user enters the displayed captcha and clicks ‘OK’, it will be saved to the string “captchaVal”.*/			
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		
		driver.findElement(By.xpath("//input[@id='nlpAnswer']")).sendKeys(captchaVal);;
	}

}
