package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	//Declaration
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	//Initialization
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//Utilization
	
	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}
	
	//Business Library
	
	public void clickOnCreateOrgLookUpImg()
	{
		createOrgLookupImg.click();
	}
	
	
	
	

}
