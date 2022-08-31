package com.gmail.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAndSignUp {
	
	public WebDriver driver;
	public String passwordText;
	public String passwordMismatchAlert;
	public String userStatus;

	public LoginAndSignUp() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		this.driver = new ChromeDriver();

	}

	public void createAccountForPersonalUse(String firstname, String lastname, String username, String pwd) {

		driver.findElement(By.xpath("//span[contains(.,'Create account')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'For my personal use')]")).click();
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.name("Username")).sendKeys(username);
		driver.findElement(By.name("Passwd")).sendKeys(pwd);
		driver.findElement(By.name("ConfirmPasswd")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		passwordText = driver.findElement(By.name("ConfirmPasswd")).getText();
		driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();

	}

	public void createAccountForPersonalUseWithWrongPassword(String firstname, String lastname, String username,
			String pwd) {

		driver.findElement(By.xpath("//span[contains(.,'Create account')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'For my personal use')]")).click();
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.name("Username")).sendKeys(username);
		driver.findElement(By.name("Passwd")).sendKeys(pwd);
		driver.findElement(By.name("ConfirmPasswd")).sendKeys(pwd + "abc");
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		passwordMismatchAlert = driver.findElement(By.xpath("//div[@jsname=\"B34EJ\"]//span")).getText();
		driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();

	}

	public void verifyPhoneNumber(String mobileNumber, String code) {

		driver.findElement(By.id("phoneNumberId")).sendKeys(mobileNumber);
		driver.findElement(By.name("code")).sendKeys(code);
		driver.findElement(By.xpath("//span[text()=\"Verify\"]")).click();
	}

	public void loginWithValidCredentials(String username, String pwd) {
         driver.findElement(By.name("identifier")).sendKeys(username);
         driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();
         driver.findElement(By.name("Passwd")).sendKeys(pwd);
         driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();
         userStatus = driver.findElement(By.xpath("//h1")).getText();
	}

	public void loginWithInValidCredentials() {

	}

	
		
	}


