package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNGpracticeinvocationCount {
	
		
		@Test(invocationCount=2,priority=2)
		
		public void createCustomer()
		{
			System.out.println("create");
		}
		
		@Test
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