package com.t.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionAlgorithm {

	public static String encryption(String data) {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data.getBytes());
			bytes = md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return BytesConvertToHexString(bytes);
	}
	
	public static String BytesConvertToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
	    for (byte b : bytes) {
	    	String str = Integer.toHexString(0xff & b);
	        if(str.length() == 1) {
	            sb.append("0" + str);
		    } else {
		        sb.append(str);
		    }
		}
		return sb.toString();
    }
	
}
