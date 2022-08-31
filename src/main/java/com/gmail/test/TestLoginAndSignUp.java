package com.gmail.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gmail.pageobject.LoginAndSignUp;

public class TestLoginAndSignUp {
	
	WebDriver driver;
	WebDriverWait wait;
	String parentwindowname = null;
	LoginAndSignUp LoginSignUp;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browser) throws InterruptedException {
		// TODO Auto-generated method stub
	    LoginSignUp = new LoginAndSignUp();
	    
	    this.driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Define
		driver.get("http://gmail.com/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
	     driver.quit();
	}
	
	@Test(groups ="regression")
	public void testLoginForPersonalAccount() {
		
		LoginSignUp.createAccountForPersonalUse("Gaous", "Test", "gaoustest", "gaous@123");
		Assert.assertEquals(LoginSignUp.passwordText, "Password@123");
		LoginSignUp.verifyPhoneNumber("88888272727", "767949");
		Assert.assertEquals(LoginSignUp.userStatus, "Successfully Created");
		
	}

}
