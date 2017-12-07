package com.SWF.utils;

public class RandomNumberGenerator {

	private static String [] charSet = {"0","1","2","3","4","5","6","7","8","9"};
	
	public static String generateRandomNum() {
		
		String randomNum = "";

		for (int i = 0; i < 6; i++) {
			int tmp = (int)(Math.random()*charSet.length);
			randomNum += charSet[tmp];
		}
		
		return randomNum;
	}
    
}
