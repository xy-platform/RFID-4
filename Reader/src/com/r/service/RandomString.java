package com.r.service;

import java.util.Random;

public class RandomString {
	
	public static String getRandomHexString(int length) {      
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {
	    	int number = new Random().nextInt(16);
	    	sb.append(Integer.toHexString(number));
	    }     
	    return sb.toString();     
	}
	
}
