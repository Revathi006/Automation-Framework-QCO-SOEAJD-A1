package vtiger.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplimentation.class)
public class CreateContactWithOrganizationTest  extends BaseClass{

	@Test(groups="SmokeSuite")
	
	public void createContactWithOrganizationTest() throws Throwable {

		
		/* read Data from ExcelFile */
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 3);

		// Step 3: Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("Clicked on Organizations link");

		// Step 4: Click On create Organization Look Up Image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Clicked on Organizations look up image");

		// Step 5: Create Organization with mandatory Information
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("Organization created");

		
		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
		
		//Step 9: Click on Contacts Link
		hp.clickOnContactLink();
		Reporter.log("Clicked on contacts link");
		
		//Step 10: Click on Create Contact Look Up image
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("Clicked on Contacts look up image");
		
		//Step 11: create Contact using the organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		Reporter.log("Contact created");
		
		//Step 12: Validate for Contacts
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		
		
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader);
	}
	
	@Test
	public void demo()
	{
		System.out.println("hello");
		System.out.println("hello every one");
		System.out.println("another change");
	}
	

}