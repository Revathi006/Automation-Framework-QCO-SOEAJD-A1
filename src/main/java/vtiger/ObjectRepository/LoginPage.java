package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //Rule 1 :create a seperate pom class for every web page
	
	//Rule 2 :identify the web elements using @FindBy,@FindAll,@FindBys
	//Declaration
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;//element name given as userNameEdt becz its a text field
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;//element name given as passwordEdt becz its a text field
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;//its a button

	private CharSequence PASSWORD;
	
	//Rule 3 :create a constructor to initialize the web elements
	//Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 :provide getters for accessing the web elements
		//Utilization
		//right click source>generate getters and setters>generate getter>generate
	
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//rule 5 :provide business library-Framework developers idea
	    //its a generic method created using web elements present only in the current page
	//for every action which are performing we can create business libraries.so that we can 
	//avoid the actions in test scripts and call the method and test scripts will be clean
	
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	

}
