package io.github.richardmars.utils;

import java.lang.String;

public class StringGenerator {
	
	public static String generateAssitantTriggerString() {
		String result = "";
		for (char i = 'a'; i < 'z'; i++) {
			result += i;
		}
		for (char i = 'A'; i < 'Z'; i++) {
			result += i;
		}
		return result;
	}
}
