package com.tekpyramid.chaingrid.generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ChainGrid_Properties_Utility {

	public String getDataFromChainGridProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./TestData/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
