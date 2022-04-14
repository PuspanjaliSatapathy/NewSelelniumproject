package common;

import org.testng.annotations.DataProvider;

public class excelDataprovide {
	
	@DataProvider(name= "test1data")
	public static Object[][] getData(){
		String excelpath = "/testdata/Book1.xlsx";
		String sheetName = "Sheet1";
		Object Data [][] =read(excelpath,sheetName);
		return Data;
	}

	public static Object[][] read(String xlpath, String sheetname) {
		excelUtil excel = new excelUtil(xlpath,sheetname);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object Data [][] = new Object[rowCount-1][colCount];

		try{
			for (int i =1;i<rowCount;i++){
				for (int j =0;j<colCount;j++){

					String cellvalue = excel.celldatastring(i, j);
					System.out.println("Row :"+i+" Coumn :"+j+"  :"+cellvalue);
					Data[i-1][j] = cellvalue;

				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return Data;
	}

}
