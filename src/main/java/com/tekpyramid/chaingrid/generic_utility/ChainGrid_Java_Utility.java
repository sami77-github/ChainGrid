package com.tekpyramid.chaingrid.generic_utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ChainGrid_Java_Utility {

	public ChainGrid_Java_Utility() {
		super();
	}

	/*
	 * Generate Random Number
	 */
	public int generateRandomNum() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}
	
	/*
	 * Generate Date
	 */
	public String generateDate() {
		String date = new Date().toString().replace(" ", "").replace(":", "");
		return date ;
	}
	
	/*
	 * Generate SimpleDate
	 */
	public String generateSimpleDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("ddMMyyyy");
		String simpleDate = sim.format(date);
		return simpleDate;
	}
}
