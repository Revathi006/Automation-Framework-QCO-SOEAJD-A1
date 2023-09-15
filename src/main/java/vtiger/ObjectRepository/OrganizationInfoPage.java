package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgheaderText;
	
	@FindBy(name="Delete")
	private WebElement deleteBtn;
	
	@FindBy(name="Edit")
	private WebElement editBtn;
	
	//Initialization
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//Utilization
	
	public WebElement getEditBtn() {
		return editBtn;
	}



	public WebElement getHeaderText() {
		return OrgheaderText;
	}
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	//Business Library

	//for validation we should never compare the org header text in src/main/java--automation standard
	//it should be decided by coder.
	public String getOrgHeader()
	{
		return OrgheaderText.getText();
	}
	
	/**
	 * This method will click on delete button
	 */
	
	public void clickDeleteButton()
	{
		deleteBtn.click();
	}
	
	/**
	 * This method will click on edit button
	 */
	public void clickEditButton()
	{
		editBtn.click();
	}
	

}
