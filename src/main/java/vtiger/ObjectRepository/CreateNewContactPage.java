package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	//Declaration
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgLookUpImg;
	
	@FindBy(id="search_txt")
	private WebElement searchOrgEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	//Initialization
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getSearchOrgEdt() {
		return searchOrgEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library-2 overloaded methods are used here.
	//we dont have to create precondition in pom class first.precondition should be written in testScripts.
	/**
	 * This method will create a contact with mantatory field
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create contact using organisation
	 * @param LASTNAME
	 * @param ORGNAME
	 * @param driver
	 */
	public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver)//here ORGNAME is a runtime information
	//this ORGNAMEwill be generated only when we write it in testscript...so its a dynamic value.for dynamic information we
	//cannot use @findBy,insteadwe shld write xpath
	{
		lastNameEdt.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchToWindow(driver,"Accounts");//Accounts-part of the page url tobe switched
		searchOrgEdt.sendKeys(ORGNAME);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();//dynamic xpath
		//a[text()='Qspiders1'] is same as //a[.=''] -regular xpath foe reference.
		//a[text()='"+ORGNAME+"']-->dymanic xpath
		//we can use driver.findElement(By.linkText(ORGNAME)) also;
		switchToWindow(driver,"Contacts");//part of the page url-ie parent window
		saveBtn.click();
	}
	
	
}
