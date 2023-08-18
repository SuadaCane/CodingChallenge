package Suada.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Suada.AbstractComponents.AbstractComponent;

public class Filters extends AbstractComponent{
	
	WebDriver driver; 
	public Filters(WebDriver driver) {
		super(driver);
		//initialazing code
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[text()='Women']")
	WebElement womenmenu;
	
	@FindBy(xpath="//a[@id='ui-id-9']//span[contains(text(),'Tops')]")
	WebElement topsmenu;
	
	@FindBy(xpath="//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
	WebElement jacketsmenu;
	
	@FindBy(xpath="//*[@id=\"narrow-by-list\"]/div[4]/div[1]")
	WebElement colorfilter;
	
	@FindBy(xpath="//a[@aria-label=\"Yellow\"] //div[@option-label=\"Yellow\"]")
	WebElement yellowcolor;
	
	public void SelectJacket() {
		Actions actions = new Actions(driver);
		actions.moveToElement(womenmenu).perform();
		actions.moveToElement(topsmenu).perform();
		jacketsmenu.click();
		
	}
	
	public void colorFilter() {
		colorfilter.click();
		yellowcolor.click();
		
		
	}

}
