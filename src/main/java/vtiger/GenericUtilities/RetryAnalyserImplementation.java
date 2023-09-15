package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implmentation for IRetryAnalyser interface of TestNG
 * @author dell
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count=0;
	int retryCount=2;
	
	public boolean retry(ITestResult result) {
		
		while(count<retryCount)
		{
			count++;
			return true;//run
			
		}
		return false;//stop while loop
	}
}
