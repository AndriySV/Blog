package com.as.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class PasswordEncoder {
	private static final String ENCODING_ALGORITHM = "SHA-256";
	
	public static String encode(String password) {
		try {
			byte[] bytePassword = password.getBytes();
			MessageDigest messageDigest = MessageDigest.getInstance(ENCODING_ALGORITHM);
			byte[] byteHashPassword = messageDigest.digest(bytePassword);
			
			String hashedPassword = Hex.encodeHexString(byteHashPassword);
			
			return hashedPassword;
		} catch (NoSuchAlgorithmException e) {
//			TODO LOG
			e.printStackTrace();
		}
		return null;
	}
}
