package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNGPracticePriority {
	
	@Test(priority=-2)
	
	public void createCustomer()
	{
		System.out.println("create");
	}
	
	@Test()
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test
	public void deleteCustomer()
	{
		System.out.println("delete");
	}

}
