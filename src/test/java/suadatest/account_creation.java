package suadatest;

import org.testng.annotations.Test;
import org.junit.Assert;

import Suada.pageobjects.CreateAccount;
import io.github.bonigarcia.wdm.WebDriverManager;
//import junit.framework.Assert;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class account_creation {
	
  @Test
  public void CreateAccount() {
	  //download automatically chromedriver
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  //Object
	  CreateAccount createaccpage = new CreateAccount(driver);
	  String email = createaccpage.emailgenerator("test.test");
	  createaccpage.goTo();
	  createaccpage.createaccount("Suada", "Cane", email, "Test123!", "Test123!");
	  
	    WebElement createaccsuccess= driver.findElement(By.xpath("//div[@role='alert']"));
		Assert.assertEquals(true, createaccsuccess.isDisplayed());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		createaccpage.logout();
		createaccpage.goTo();
		createaccpage.Signin(email,"Test123!");
		Assert.assertEquals("Welcome, Suada Cane!", createaccpage.WelcomeText());
		createaccpage.logout();
		driver.close();
		driver.quit();
		
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.greet.welcome > span")));
		
	//String msg= driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Suada Cane!']")).getText();
	
	//Assert.assertEquals("Welcome, Suada Cane!", msg); 
	  
  }

}
