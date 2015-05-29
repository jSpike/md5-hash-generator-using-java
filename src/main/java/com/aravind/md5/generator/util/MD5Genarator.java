/**
 * 
 */
package com.aravind.md5.generator.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.aravind.md5.generator.MD5Genaral;



/**
 * @author aravind
 *
 */
public class MD5Genarator {
	private static final Logger LOG = Logger.getLogger(MD5Genarator.class);	
	public static enum MESSAGE_DIGEST_ALGORITHM_TYPE {
		MD5, SHA160 , SHA256
	}
	
	public static String generateMD5HashString(String message, MESSAGE_DIGEST_ALGORITHM_TYPE TYPE){
		StringBuffer hashString = null;
		String algorithm = TYPE.name();
		LOG.info("-----algorithm type---"+algorithm);
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
	/**
	 * To get SHA-256 hashed values
	 * @param message
	 * @param TYPE
	 * @return {@link String}
	 */
	public static String generateSHA256HashString(String message, MESSAGE_DIGEST_ALGORITHM_TYPE TYPE) {
		StringBuffer shaHasedString = new StringBuffer();
		try {
	        MessageDigest md;
	        String algorithem = "SHA-256";
			md = MessageDigest.getInstance(algorithem);
			md.update(message.getBytes());
		    byte byteData[] = md.digest();
	        for (int i = 0; i < byteData.length; i++) {
	        	shaHasedString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        LOG.info("----sha-256-"+shaHasedString.toString());
		} catch (NoSuchAlgorithmException e) {
			LOG.error(e);
		}
		return shaHasedString.toString();
	}

}
