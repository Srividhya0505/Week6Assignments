package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadsTestCases extends BaseClass {
	public static String leadID;
	
		
	@When("Click CreateLead option")
	public void clickLeadsandCreateLeads() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@And ("Enter CompanyName {string}")
	public void enterCompanyName(String company) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
	}

	@And("Enter FirstName {string}")
	public void enterFirstName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}

	@And("Enter LastName {string}")
	public void enterLastName(String LName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LName);
	}

	@And("Enter PhNum {string}")
	public void enterPhNum(String phNO) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNO);
	}

	@And("click CreateLeadButton")
	public void clickCreateLead() {
		driver.findElement(By.name("submitButton")).click();

	}

	@Then("Verify Lead is successfully created")
	public void verifyLead() {
		SoftAssert softAssert = new SoftAssert();
		WebElement title = driver.findElementByXPath("//div [text()='View Lead']");
		String actTitle = title.getText();
		String expTitle = "View Lead";
		softAssert.assertEquals(expTitle, actTitle);
		System.out.println("Lead is successfully created");
		softAssert.assertAll();
	}

	@Given("Click FindLeads")
	public void findLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@When("click PhTab")
	public void clickPhTab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@And("Enter PhNumber {string}")
	public void enterPhNumber(String phNO) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNO);
	}

	@And("Click Find Leads Button")
	public void clickFindLeadsButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
	}

	@And ("Click FirstResultRecord")
	public void clickFirstResult() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(4000);
	}

	@And("Click EditButton")
	public void clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@And("UpdateCompanyName {string}")
	public void updateCompName(String company) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
	}

	@And("click UpdateButton")
	public void clickUpdateButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then ("Store FirstResultRecord")
	public void storeFirstResultRecord() {
		 WebElement empID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
	      leadID = empID.getText();
	}

		
	@And ("Click Delete")
	public void clickDelete() {
		driver.findElement(By.linkText("Delete")).click();
	}

	@When ("Click FindLeads Option")
	public void clickfindLeadsoption () {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@And ("Give StoredResultRecordandFindLeads")
	public void searchwithStoredResultRecord () throws InterruptedException {
		 driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
	}

	@Then ("Verify if record is displayed")
	public void verifyRecorddisplayed () {
		SoftAssert softAssert = new SoftAssert();
		String expText = driver.findElement(By.className("x-paging-info")).getText();
		String actText = "No records to display";
		softAssert.assertEquals(actText, expText);
			System.out.println("Record is not displayed");
			softAssert.assertAll();
		} 
		
	
	@Then ("Click DuplicateLead Button")
	public void clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	
	@When ("Click MergeLead Link")
	public void clickMergeLead() {
		driver.findElement(By.linkText("Merge Leads")).click();
		}
	
	@And ("Click FromLead Lookup Search")
	public void clickFromLeadLookupSearch() throws InterruptedException  {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
			Thread.sleep(2000);
	}		
	
		
	@And ("Enter First MergeLead Name {string}")
		public void enterFirstMergeLeadName (String FName) throws InterruptedException {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(FName);
		
	}
	
	@And ("Navigate to Main Window")
	public void navigateToMainWind() {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(0));
	}
	
	@When ("Click ToLead Lookup Search")
		public void clickToLeadLookupSearch() {
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			Set<String> allWindows2 = driver.getWindowHandles();
			List<String> allhandles2 = new ArrayList<String>(allWindows2);
			driver.switchTo().window(allhandles2.get(1));
		}
	 
	@And ("Enter Second MergeLead Name {string}")
		public void enterSecondMergeLeadName(String SName) {
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(SName);
		}
		
		
	@And ("Navigate to Main Window again")
		public void navigateToMainWindFromSecondWind () {
			Set<String> allWindows2 = driver.getWindowHandles();
			List<String> allhandles2 = new ArrayList<String>(allWindows2);
			driver.switchTo().window(allhandles2.get(0));
		}
		
	@And ("Click Merge Button")
		public void clickMergeButton() {
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
			
		}
		
	@And ("Accept Alert")
		public void acceptAlert() {
			driver.switchTo().alert().accept();
			
		}
		
		
		
		
		
	}

	
	
	
