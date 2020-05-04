package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@title='Privathaftpflicht']")
	WebElement Privathaftpflicht;
	
	
	private String insuranceInfo=".//input[@id='%s']/../span";
	
	//private String isPublicServant="//li[contains(@class,'answer')]/div/input[@value='%s']/../span";
	
	@FindBy(xpath="//li[contains(@class,'answer')]/div/input[@value='Ja']/../span")
	WebElement isPublicServant;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement comments;
	
	public InsurancePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnPrivathaftpflicht()
	{
		Privathaftpflicht.click();
	}
	
	public WebElement privathaftpflichtEle()
	{
		return Privathaftpflicht;
	}

	
	public InsurancePage clickInsurer(String insurer)
	{
		driver.findElement(By.xpath(String.format(insuranceInfo, insurer))).click();
		return this;
	}
	
	public InsurancePage isPublicServantOption(String yesOrNo)
	{
		isPublicServant.click();
		
		return this;
	}
	
	public WebElement isPublicServantEle()
	{
		return isPublicServant;
	}
	
	public InsurancePage wantDeductible(String yesOrNo)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(String.format(insuranceInfo, yesOrNo))).click();
		return this;
	}
	
	
	public InsurancePage writeComment(String comment)
	{
		
		comments.sendKeys(comment);
		return this;
	}
	
	public WebElement commentEle()
	{
		return comments;
	}
}
