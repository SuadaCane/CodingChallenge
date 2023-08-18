package Suada.pageobjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Suada.AbstractComponents.AbstractComponent;


public class CreateAccount extends AbstractComponent {
	
	
	//Create constructor, first method to execute
	WebDriver driver; 
	public CreateAccount(WebDriver driver) {
		
		super(driver);
		//initialazing code
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory -- design pattern
	@FindBy(linkText="Create an Account")
	WebElement link;
	
	@FindBy(id="firstname")
	WebElement firstname;
	
	@FindBy(id="lastname")
	WebElement lastname;
	
	@FindBy(id="email_address")
	WebElement emailaddress;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="password-confirmation")
	WebElement passconfirm;
	
	@FindBy(css="button[title='Create an Account']")
	WebElement btn;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement successmsg;
	
	@FindBy(css="div[class='panel header'] button[type='button']")
	WebElement dropdown;
	
	@FindBy(linkText="Sign Out")
	WebElement signoutlink;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="pass")
	WebElement pass;
	
	@FindBy(id="send2")
	WebElement btnSignIn;
	
	@FindBy(linkText="Sign In")
	WebElement linkSignIn;
	
	@FindBy(xpath="//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Suada Cane!']")
	WebElement wlcmtext;
	
	By welcomemsg=By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.greet.welcome > span");
	
	//Generate unique email
	public String emailgenerator(String em1) { 
		Random rand= new Random();
		int n=rand.nextInt(10000);
		String em= em1 + n + "@gmail.com";
		return em;
	}
	
	//logic to create account
	
	public void createaccount(String fn, String ln, String em1, String pass, String passc) {
		link.click();
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		emailaddress.sendKeys(em1);
		password.sendKeys(pass);
		passconfirm.sendKeys(passc);
		btn.click();	
			
	}
	//logic to logout;
	public void logout() {
		dropdown.click();
		signoutlink.click();
		
	}
	
	//logic to SignIn
	public void Signin(String em, String passw) {
		linkSignIn.click();
		email.sendKeys(em);
		pass.sendKeys(passw);
		btnSignIn.click();		
		
	}
	
	public String WelcomeText() {
		waitForElementToAppear(welcomemsg);
	    return wlcmtext.getText();
		
	}
	

	
	//logic to open the url
	
	public void goTo() {
		driver.get("https://magento.softwaretestingboard.com");
	}
	
}
