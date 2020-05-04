package commonfuncs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility {

	WebDriver driver;
	
	public Utility(WebDriver driver)
	{
		this.driver=driver;
	}
	public void waitForEle(int secs, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void scrollToElement(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", ele);
	}
	
	public void scrollToTheBottom()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void handlePopup(String xpath)
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> list=driver.findElements(By.xpath(xpath));
		if(list.size()>0)
		{
			list.get(0).click();
		}
		
	}
}
