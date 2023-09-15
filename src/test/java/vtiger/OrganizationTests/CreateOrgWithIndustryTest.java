package vtiger.OrganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateOrgWithIndustryTest extends BaseClass{
	
@Test(groups="RegressionSuite")
	
public void createOrgWithIndustryTest() throws Throwable {
		
		
		/*read data from excel file*/
		
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcel("Organizations", 4, 3);
	

		//Step 3: Navigate to Organizations link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 4: Click on Create Organization Look up Image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 5: Create organization with mandatory Fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
				cnop.createNewOrganization(ORGNAME, INDUSTRYTYPE);
		
		
		//Step 8: Validate for Organization
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String orgHeader = oip.getOrgHeader();
						
			//	if(orgHeader.contains(ORGNAME))
			//
			//	{
			//		System.out.println(orgHeader+"----PASS-----");
			//	}
			//	else
			//	{
			//		System.out.println("----FAIL----");
			//	}
				Assert.assertTrue(orgHeader.contains(ORGNAME));
				System.out.println(orgHeader);
	}
@Test//since groups are not assigned to thid @Test,it will not be executed when 
     //suite fileis run..
public void demo()
{
	System.out.println("demo");
}
}

