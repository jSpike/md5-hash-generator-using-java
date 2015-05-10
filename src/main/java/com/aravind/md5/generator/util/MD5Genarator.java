/**
 * 
 */
package com.aravind.md5.generator.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * @author aravind
 *
 */
public class MD5Genarator {
	public static final Logger LOG = Logger.getLogger(MD5Genarator.class);
	
	public static String generateMD5HashString(String message, String algorithm){
		StringBuffer hashString = null;
		if(!message.isEmpty() && !message.equals(null) && !algorithm.isEmpty() && !algorithm.equals(null)){
			try {
				MessageDigest msgDigest = MessageDigest.getInstance(algorithm);
				byte[] messageInByte = message.getBytes();
				msgDigest.update(messageInByte);
				byte[] messageHashInByte = msgDigest.digest();
				hashString = new StringBuffer();
				for(int i=0; i<messageHashInByte.length; i++){
					hashString.append(Integer.toString((messageHashInByte[i] & 0xff) + 0x100, 16).substring(1));
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		LOG.info("-----------hashed value==="+hashString);
		return hashString.toString();
	}

}
