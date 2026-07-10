package com.comcast.crm.generalutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtility
{
public  String ToReadDataFromProp(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream("./\\src\\test/resource\\comm.properties");
	Properties prop=new Properties();
	prop.load(fis);;
	String value=prop.getProperty(key);
	return value;
}

}
