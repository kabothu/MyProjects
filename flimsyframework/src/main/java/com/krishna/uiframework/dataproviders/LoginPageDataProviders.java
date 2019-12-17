package com.krishna.uiframework.dataproviders;

import org.testng.annotations.DataProvider;

import com.krishna.uiframework.utils.ExcelFileUtility;


public class LoginPageDataProviders {
	
	private static ExcelFileUtility excelFileUtils = new ExcelFileUtility(); 
	
	@DataProvider(name="empLogin")
	public static Object[][] loginData() {
		String currentDir = System.getProperty("user.dir");
		String filePath = (currentDir + "/src/main/resources/com/krishna/testData/ExcelData.xls").replace('\\',
				'/');
		Object[][] arrayObject = excelFileUtils.getExcelData(filePath, "Sheet1");
		return arrayObject;
	}

}
