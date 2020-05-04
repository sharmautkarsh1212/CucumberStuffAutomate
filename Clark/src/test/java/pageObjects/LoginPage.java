package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//*[@type='email']")
	WebElement username;
	
	@FindBy(xpath="//*[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement submit;

	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String usname, String pwd)
	{
		username.sendKeys(usname);
		password.sendKeys(pwd);
		submit.click();
	}
	
	public WebElement userEle()
	{
		return username;
	}
	
}
