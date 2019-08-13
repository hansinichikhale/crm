package crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import crm.testbase.TestBase;

public class TestUtil extends TestBase {
	public static long Page_Load_TimeOuts=30;
	public static long Implicitly_Wait=20;
	public static String ADD_DATA_SHEET_PATH="C:\\Users\\Public\\CRMx2crm\\src\\main\\java\\crm\\qa\\testdata\\AddDatainTable.xlsx";
public static Workbook workbook;
public static Sheet sheet;

public static Object[][]  GetData(String sheetName){
	FileInputStream fis=null;
	try {
		fis=new FileInputStream(ADD_DATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
	
		e.printStackTrace();
	}
	try {
		workbook=WorkbookFactory.create(fis);
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sheet=workbook.getSheet(sheetName);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	System.out.println(sheet.getLastRowNum()+"--------");
	sheet.getRow(0).getLastCellNum();
	for(int i=0;i<sheet.getLastRowNum();i++) {
for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
	data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	System.out.println(data[i][k]);
}
	}
	return data;
}
}
