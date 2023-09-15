package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void hardAssert()
	{
		System.out.println("Hi Started");
		Assert.assertEquals("a", "b");
		
		System.out.println("Heloo i am here");
	}
	
	@Test
	public void softAssert()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step 1 ");
		
		sa.assertEquals(1, 2);//fail
		
		System.out.println("Step 2 ");
		
		sa.assertTrue(false);//fail
		
		System.out.println("Step 3 ");
		System.out.println("Step 4 ");
		System.out.println("Step 5 ");
		
		sa.assertAll();
	}
	
	@Test
	public void hardAndSoft()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1 ");
		System.out.println("Step2 ");
		
		sa.assertTrue(false);//fail
		
		System.out.println("Step3 ");
		
		sa.assertEquals(1, 2);//fail
		
		System.out.println("Step4 ");
		
		Assert.assertEquals(false, true);//ignored all other softasserts above this.
		
		System.out.println("Step5 ");
		
		sa.assertAll();
	}
}
