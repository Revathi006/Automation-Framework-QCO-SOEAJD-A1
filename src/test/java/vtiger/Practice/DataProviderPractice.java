package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider="getData")
	
public void addProductToCart(String name,String model,int price)
{
	System.out.println(name+"-"+model+"-"+price);
}
	
	@DataProvider
	public Object[][] getData()
	{                          //row//column
		Object[][] data=new Object[2][3];//2 sets of data with 3 fields/info
		
		data[0][0]="Samsung";
	    data[0][1]="A80";
	    data[0][2]=15000;
	    
	    data[1][0]="Vivo";
	    data[1][1]="Y21";
	    data[1][2]=9000;
	    
		return data;
	}
	
	
	
	
}
