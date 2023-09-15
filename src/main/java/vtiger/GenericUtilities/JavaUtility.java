package vtiger.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists if reusable methods related to JAVA
 * @author dell
 *
 */
public class JavaUtility {

	/**
	 * this method will return random number for every execute
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	
	
	/**
	 * This method will return the current system date in specific format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");//MM-month  ,mm-minute
		String date = formatter.format(d);
		return date;
	}
}
