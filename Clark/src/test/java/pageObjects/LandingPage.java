package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage{

	
	@FindBy(xpath="//li/a[contains(@class,'offers')]")
	WebElement angebote;
	
	public LandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnAngebote()
	{
		angebote.click();
	}
	
	public WebElement angebotEle()
	{
		return angebote;
	}
	
}
