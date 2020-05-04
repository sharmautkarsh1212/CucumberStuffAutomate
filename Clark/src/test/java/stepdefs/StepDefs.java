package stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.datatable.DataTable;
import commonfuncs.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.InsurancePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.OrderPage;
import pageObjects.PersonalInfo;
import pageObjects.RequestAQuote;

public class StepDefs{

	WebDriver driver;
	LandingPage landingPage;
	InsurancePage insurancePage;
	RequestAQuote requestAQuote;
	Utility utility;
	LoginPage login;
	PersonalInfo personalInfo;
	OrderPage orderPage;
	
	
	@Before
	public void setupBrowser() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		landingPage = new LandingPage(driver);
		insurancePage = new InsurancePage(driver);
		requestAQuote = new RequestAQuote(driver);
		utility = new Utility(driver);
		login = new LoginPage(driver);
		personalInfo=new PersonalInfo(driver);
		orderPage=new OrderPage(driver);
	}
	 
	
	
	@Given("The landing page is {string}")
	public void getLandingPage(String URL)
	{
		driver.get(URL);
		utility.waitForEle(30, landingPage.angebotEle());
		
		
	}
	
	
	@When("I click on {string}")
	public void i_click_on(String string) {
	 
		switch (string) {
		case "Angebote":
			landingPage.clickOnAngebote();
			break;
		
		case "Privathaftpflicht":
			insurancePage.clickOnPrivathaftpflicht();
			break;
			
		case "Jetzt abschlien":
			utility.waitForEle(10, requestAQuote.primaryBtn());
			requestAQuote.clickOnPrimaryBtn();
			break;
			
		case "Overview":
			orderPage.clickOverview();
			break;
 
		default:
			break;
		}
		
		
	}

	@Then("{string} is present on the landing page")
	public void is_present_on_the_landing_page(String string) {
	    
		switch (string) {
		case "Privathaftpflicht":
			utility.waitForEle(30, insurancePage.privathaftpflichtEle());
			assertEquals("Checking if Privathaftpflicht is present on the page",true, insurancePage.privathaftpflichtEle().isDisplayed());
			break;

		default:
			break;
		}
		
	}

	@Then("I land on the request quote page")
	public void i_land_on_the_request_quote_page() {
		utility.waitForEle(30, requestAQuote.checkBoxEle());
		assertEquals("checking if user is on request a quote page",true, requestAQuote.checkBoxEle().isDisplayed());

	    
	}

	@Then("I request a quote")
	public void i_request_a_quote() {
	    requestAQuote.clickOnCheckBox().clickrequestAQuoteBtn();
	}

	@Then("I select the following options from the consecutive pages")
	public void i_select_the_following_options_from_the_consecutive_pages(DataTable dataTable) throws InterruptedException {
		 List<List<String>> list = dataTable.asLists(String.class);		 
	    insurancePage.clickInsurer(list.get(0).get(0));
	   utility.waitForEle(10,insurancePage.isPublicServantEle());
	    insurancePage.isPublicServantOption(list.get(0).get(1));
	    insurancePage.wantDeductible(list.get(0).get(2));
	    utility.waitForEle(10,insurancePage.commentEle());
	    insurancePage.writeComment(list.get(0).get(3));
	    
	}

	@And("I again request a quote")
	public void i_again_request_a_quote() {
	    requestAQuote.clickrequestAQuoteBtnAgain();
	}

	@Then("I am on the offers page")
	public void i_am_on_the_offers_page() {
		 utility.waitForEle(10,requestAQuote.offersBtn());
		 requestAQuote.clickOffersBtn();
	}

	@Then("I land on login page")
	public void i_land_on_login_page() {
		utility.waitForEle(10,login.userEle());
	    assertEquals("checking if user is on the login page",true, login.userEle().isDisplayed());
	    
	}

	@When("I login using the following credentials")
	public void i_login_using_the_following_credentials(DataTable dataTable) {
	   List<List<String>> list = dataTable.asLists(String.class);	
	    login.login(list.get(0).get(0), list.get(0).get(1));
	}

	@And("I fill in the following details and continue")
	public void i_fill_in_the_following_details_and_continue(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
	    utility.waitForEle(14, personalInfo.fieldOnInfoPage());
	    
	    personalInfo.fillInDetails(list.get(0).get("First Name"), list.get(0).get("Last Name"), list.get(0).get("DOB"),
	    		list.get(0).get("road"), list.get(0).get("house no"), list.get(0).get("PLZ"), 
	    		list.get(0).get("place"), list.get(0).get("phone"));
	   
	}

	@Then("I fill in the bank details {string} and continue")
	public void i_fill_in_the_bank_details_and_continue(String string) {
		utility.waitForEle(10, personalInfo.rdoBtn());
		//utility.scrollToElement(personalInfo.accField());
		utility.scrollToTheBottom();
	    personalInfo.fillBankDetails(string);
	}

	@Then("I verify the details on the verification page and click on Buy now")
	public void i_verify_the_details_on_the_verification_page_and_click_on() {
		utility.waitForEle(12, personalInfo.overviewPage());
		//utility.scrollToElement(personalInfo.overviewScroll());
		utility.scrollToTheBottom();
		personalInfo.confirmAll();
	}

	@Then("I land on the order completed page")
	public void i_land_on_the_order_completed_page() {
	   utility.waitForEle(10, orderPage.orderConfirmation());
	}

	@Then("I land on the manager page")
	public void i_land_on_the_manager_page() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	   assertEquals("checking if user has navigated till the manager page",true, driver.getCurrentUrl().contains("manager"));
	}

	@And("I see my contract as expected")
	public void i_see_my_contract_as_expected() {
		
		utility.handlePopup(orderPage.closePopupXpath());
	    assertEquals("verifying if contracts have been added for the user",true, orderPage.isContractDisplayed().isDisplayed());
	}
	
	
	 @After public void closeBrowser() {
		  driver.quit(); }
	 }
	 

	

