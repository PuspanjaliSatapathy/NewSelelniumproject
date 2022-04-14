package common;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtil {
	static String path = System.getProperty("user.dir");
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public excelUtil(String xlpath, String sheetname){
		try{
		
		path = System.getProperty("user.dir");
		workbook = new XSSFWorkbook(path+xlpath);
		sheet = workbook.getSheet(sheetname);
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
	public static int getRowCount(){
		int rowcount = 0;
		try {

		rowcount = sheet.getPhysicalNumberOfRows();

		
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowcount;
	}
	public static int getColCount(){
		int colCount = 0;
		try {

		colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}

	public static String celldatastring(int rowNum, int coulmNnum){
		String cellvalue= null;
		try {

		int rowcount = sheet.getPhysicalNumberOfRows();
		cellvalue = sheet.getRow(rowNum).getCell(coulmNnum).getStringCellValue();

		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellvalue;
		
	}
	public static Double celldatanumber(int rowNum, int coulmNnum){
		Double cellvalue = null;
		try {

		int rowcount = sheet.getPhysicalNumberOfRows();
		cellvalue = sheet.getRow(rowNum).getCell(coulmNnum).getNumericCellValue();

		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellvalue;
	}
	

}
