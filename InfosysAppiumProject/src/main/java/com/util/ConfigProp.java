package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProp {
	
	private static  Properties prop;

	private static void initilizeProperties() {
		 try {
			 prop = new Properties();
			 InputStream input = new FileInputStream("D:/InfosysAppiumProject/src/main/resources/config.properties");          

	         prop.load(input);         

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}
	
	public static String getProperty(String propName) {
		if(prop==null) {
			initilizeProperties();
		}
		return prop.getProperty(propName);
	}
}
