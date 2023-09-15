package vtiger.Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(vtiger.GenericUtilities.ListenersImplimentation.class)
public class ListenersPractice {
	
	@Test
	public void demo()
	{
		Assert.fail();
		System.out.println("HI");
	}
	
	@Test(dependsOnMethods="demo")
	public void demo1()
	{
		System.out.println("hello");
	}
	
	

}
