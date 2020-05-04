package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfo {
	
	
	@FindBy(xpath="//ul[@class='_choices_1rhapd']/li[1]/label/span[1]/span")
	WebElement salutation;
	
	@FindBy(xpath="//div[@class='_panel_1kvbue']/div[2]/form/div[1]/div[1]/fieldset")
	WebElement fieldpannel;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='birthdate']")
	WebElement birthdate;
	
	@FindBy(xpath="//input[@name='street']")
	WebElement street;
	
	@FindBy(xpath="//input[@name='houseNumber']")
	WebElement houseNumber;
	
	@FindBy(xpath="//input[@name='zipcode']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='phoneNumber']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//*[contains(@class,'iban') and @type='text']")
	WebElement bankAcc;
	
	
	@FindBy(xpath="//div[contains(@class,'custom-checkbox')]/label")
	WebElement ibanCheck;
	
	
	@FindBy(xpath="//button[contains(@class,'btn btn-primary')]")
	WebElement orderTariff;
	
	@FindBy(xpath="//label[contains(@class,'custom-checkbox')]")
	WebElement checkBoxOnConfirmPage;
   
	@FindBy(xpath="//div[@class='offer-checkout__details offer-checkout__top']/dl[1]/dt")
	WebElement overViewPage;
	
	@FindBy(xpath="//div[contains(@class,'custom-radio iban')]")
	WebElement scroll;
	
	public PersonalInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement onPersonalInfoPage()
	{
		return firstName;
	}
	
	public WebElement fieldOnInfoPage()
	{
		return fieldpannel;
	}
	
	public void fillInDetails(String firstname, String lastname, String DOB, String road, String houseNr, String PLZ, String place, String num) throws InterruptedException
	{
		//Thread.sleep(3000);
		salutation.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		birthdate.sendKeys(DOB);
		street.sendKeys(road);
		houseNumber.sendKeys(houseNr);
		zipcode.sendKeys(PLZ);
		city.sendKeys(place);
		phoneNumber.sendKeys(num);
		submit.click();
	}
	
	
	public void fillBankDetails(String details)
	{
		
		bankAcc.sendKeys(details);
		ibanCheck.click();
		orderTariff.click();
	}

	public void confirmAll()
	{
		checkBoxOnConfirmPage.click();
		orderTariff.click();
	}
	
	public WebElement rdoBtn()
	{
		return scroll;
	}
	
	public WebElement overviewPage()
	{
		return overViewPage;
	}
	
	public WebElement accField()
	{
		return bankAcc;
	}
	
	
	public WebElement overviewScroll()
	{
		return checkBoxOnConfirmPage;
	}
	
}
