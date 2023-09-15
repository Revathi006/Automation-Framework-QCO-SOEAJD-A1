package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Declaration
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Products")
	private WebElement procuctLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	//Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	
	public WebElement getOrganizationsLnk() {
		return organizationLnk;
	}

	public WebElement getContactslnk() {
		return contactsLnk;
	}

	public WebElement getProcuctLnk() {
		return procuctLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	//Business Library
	//to create business library we can extends WedDriverUtility(hyrarchialinherience)
	
	/**
	 * This method will logout of application
	 * @param driver
	 */
	 public void logoutApp(WebDriver driver)throws InterruptedException
	 {
		mouseHoverAction(administratorImg, driver);
		 Thread.sleep(1000);
		 signoutLnk.click();
	 }
	 
	 
	 /**
	  * This method will click on organizations link
	  */
	 public void clickOnOrganizationLink()
	 {
		 organizationLnk.click();
	 }
	 
	 /**
	  * This method will click on contacts Link
	  */
	public void clickOnContactLink()
	{
		contactsLnk.click();
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
