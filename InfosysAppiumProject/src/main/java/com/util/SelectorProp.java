package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SelectorProp {

	
	private static Properties prop;
	
	private static void initilizeProperties() {
		 try {
			 prop = new Properties();
			 InputStream input = new FileInputStream("D:/InfosysAppiumProject/src/main/resources/selectors.properties");          

	         prop.load(input);         

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}
	
	public static String getSelector(String selector) {
		if(prop==null) {
			initilizeProperties();
		}
		return prop.getProperty(selector);
	}
}
