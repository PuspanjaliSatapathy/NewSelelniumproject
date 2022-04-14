package common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PageMapping {
	static String loactorpath = System.getProperty("user.dir");
	static Map<String,String>GlSearchMap = new HashMap<>();
	static Map<String,String>GLSearchrResultMap = new HashMap<>();


	public static String objectMappingWithPage(String page, String ObjectName) throws Exception{
		String objecteturn = null;
		
		GlSearchMap= getPropertyValue(loactorpath+"/src/test/resources/Locators/GLSearchhome.properties");
		GLSearchrResultMap= getPropertyValue(loactorpath+"/src/test/resources/Locators/GLSearchResult.properties");
		

		switch (page) {
		case "GlSearch":
			objecteturn=GlSearchMap.get(ObjectName);
			break;
			
		case "GlSearchrResult":
			objecteturn=GLSearchrResultMap.get(ObjectName);
			break;

		default: 
			System.out.println("Error in Page Mapping");
			throw new Exception ("Error in Page Mapping");

		}
		return objecteturn;

	}
	
	public static Map<String,String> getPropertyValue(String Path){
			
		Map<String,String>returnMap = new HashMap<>();
		
		
		try{
			Properties  Props = new Properties();
			InputStream readfile = new FileInputStream(Path);
			Props.load(readfile);
			Enumeration keys = Props.propertyNames();
			while (keys.hasMoreElements()){
				String tempKey = (String) keys.nextElement();
				returnMap.put(tempKey, Props.getProperty(tempKey));
			}
			readfile.close();
			return returnMap;
			
			}catch(Exception exp){
				System.out.println(exp.getMessage());
				System.out.println(exp.getCause());
				exp.printStackTrace();
				return null;
			}
				
	}



}
