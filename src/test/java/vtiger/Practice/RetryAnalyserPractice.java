package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = vtiger.GenericUtilities.RetryAnalyserImplementation.class)//retry analyser given at @Test
	                                                                                //equals copy qualified name
	public void sample()
	{
		Assert.fail();
		System.out.println("hello");
	}

}
