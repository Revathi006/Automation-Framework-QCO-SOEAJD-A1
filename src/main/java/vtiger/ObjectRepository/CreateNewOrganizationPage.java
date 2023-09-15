package vtiger.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	//Declaration
	
	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	//Initialization
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business library
	//below 2 methods are examples of method overloading
	
	/**
	 * This method will create organization with mandatory field
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		organizationNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	
	public void createNewOrganization(String ORGNAME,String INDUSTRY)
	{
		organizationNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropdown,INDUSTRY);
		saveBtn.click();
	}
	
	

}
