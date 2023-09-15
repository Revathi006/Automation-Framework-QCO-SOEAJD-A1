package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithIndustryUsingObjectRepositiry {

	
public static void main(String[] args) throws Throwable{
		
	
	    //Create Objects of all Utility classes
	
	
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		WebDriver driver=null;
		//step 1 :read all data required
		
		/*read data from property file*/
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/*read data from excel file*/
		
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcel("Organizations", 4, 3);
	
		//step 2 :launch the browser// Run Time Polymorphism-driver
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForpageLoad(driver);
		driver.get(URL);
		
		//step 2 :login toApplication//using object repository
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);//login operation

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
						
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println(orgHeader+"----PASS-----");
				}
				else
				{
					System.out.println("----FAIL----");
				}
				
		//Step 9: Logout of app
		       hp.logoutApp(driver);
		
	    //step 10: close the browser
				driver.quit();
	}
}

