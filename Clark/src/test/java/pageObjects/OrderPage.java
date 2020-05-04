package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	@FindBy(xpath="//header[contains(@class,'confirmation')]")
	WebElement confirmation;
	
	
	@FindBy(xpath="//button[contains(@class,'btn btn-primary')]")
	WebElement overviewBtn;
	
	@FindBy(xpath="//button[contains(@class,'contract')]")
	WebElement contract;
	
	
	private String closePopup="//button[contains(@class,'close')]";
	
	
	public OrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement orderConfirmation()
	{
		return confirmation;
	}
	
	public void clickOverview()
	{
		overviewBtn.click();
	}
	
	public WebElement isContractDisplayed()
	{
		return contract;
	}
	
	
	public String closePopupXpath()
	{
		return closePopup;
	}
	
	
	
}
