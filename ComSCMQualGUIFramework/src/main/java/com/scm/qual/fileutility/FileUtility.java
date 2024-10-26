package com.scm.qual.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

import com.scm.qual.ipathconstants.IPathConstants;

public class FileUtility implements IPathConstants {

	public String getDataFromPropetyFile(String key) {
		Properties p=null;
	try {
		FileInputStream fis=new FileInputStream(filePath);
		p=new Properties();
		p.load(fis);
	} catch (Exception e) {
		e.printStackTrace();
	}
	String data = p.getProperty(key);
	return data;

	
	}
}
