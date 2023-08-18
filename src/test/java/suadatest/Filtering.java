package suadatest;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Suada.pageobjects.CreateAccount;
import Suada.pageobjects.Filters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class Filtering {
	
	@Test
	public void filter() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		CreateAccount createaccpage = new CreateAccount(driver);
		createaccpage.goTo();
		createaccpage.Signin("cane.suada@gmail.com","Test123!");
		Filters filter=new Filters(driver);
		filter.SelectJacket();
		filter.colorFilter();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		List<WebElement> yellowproducts = driver.findElements(By.cssSelector(".product-item-info"));
		//List <WebElement> match = yellowproducts.stream().filter(s->s.getAttribute(null)
		//Assert.assertEquals(yellowproducts, filteredlist);
		driver.close();
		driver.quit();
	
	
	}
	  
  }

