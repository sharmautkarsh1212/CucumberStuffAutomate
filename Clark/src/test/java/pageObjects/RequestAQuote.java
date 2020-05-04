package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestAQuote {

	@FindBy(xpath="//*[@id='consent-broker']")
	WebElement checkBox;
	
	@FindBy(xpath="//button")
	WebElement requestAQuoteBtn;
	
	@FindBy(xpath="//button[contains(@class,'next')]")
	WebElement requestAQuoteAgain;
	
	@FindBy(xpath="//a[contains(@class,'button') and contains(@href,'offers')]")
	WebElement offersPageBtn;
	
	@FindBy(xpath="//button[contains(@class,'appearance-primary')]")
	WebElement jetztabschlieﬂen;
	
	public RequestAQuote(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public RequestAQuote clickOnCheckBox()
	{
		checkBox.click();
		return this;
	}
	
	public WebElement checkBoxEle()
	{
		return checkBox;
	}
	
	public RequestAQuote clickrequestAQuoteBtn()
	{
		requestAQuoteBtn.click();
		return this;
	}
	
	public RequestAQuote clickrequestAQuoteBtnAgain()
	{
		requestAQuoteAgain.click();
		return this;
	}
	
	public WebElement offersBtn()
	{
		return offersPageBtn;
	}
	
	public RequestAQuote clickOffersBtn()
	{
		offersPageBtn.click();
		return this;
	}
	
	public WebElement primaryBtn()
	{
		return jetztabschlieﬂen;
	}
	
	public RequestAQuote clickOnPrimaryBtn()
	{
		jetztabschlieﬂen.click();
		return this;
		
	}
}
