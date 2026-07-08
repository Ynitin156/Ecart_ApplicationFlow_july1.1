package DataProviders;

import org.testng.annotations.DataProvider;

import Utils.ExcelUtils;

public class dataprovider
{
	@DataProvider(name = "LoginData")
    public Object[][] getData() 
	{
        //System.out.println("DataProvider Called");
		
        ExcelUtils excel = new ExcelUtils();

        return excel.getExcelData();

    }
}
