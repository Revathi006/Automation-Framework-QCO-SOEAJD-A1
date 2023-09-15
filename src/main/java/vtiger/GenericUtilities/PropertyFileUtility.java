package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of Generic/reusable Methods related to property file
 * @author dell
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read the data from property file return the value to the caller
	 * @param PropertyFileKey
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String PropertyFileKey) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(PropertyFileKey);
		return value;
	}
	
	

}
