package com.l33tindustries.tools.string;

import java.util.Random;
import java.util.UUID;

public class StringRandom {
	
	private static final String CHAR_LIST =
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	
	
	public static String generateRandomString(int length){

		StringBuffer randStr = new StringBuffer();
		for(int i=0; i< length; i++){
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	
	private static int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}
	
	public static String generateRandomUUID()
	{
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
		return randomUUIDString;
	}
}
