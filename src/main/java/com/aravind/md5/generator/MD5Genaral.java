/**
 * 
 */
package com.aravind.md5.generator;



import org.apache.log4j.Logger;

import com.aravind.md5.generator.util.MD5Genarator;
import com.aravind.md5.generator.util.MD5Genarator.MESSAGE_DIGEST_ALGORITHM_TYPE;

/**
 * Main class for md5 hash generator
 * @author aravind
 * @date 10-05-2015
 *
 */
public class MD5Genaral {

	public static final Logger LOG = Logger.getLogger(MD5Genaral.class);
	
	/**
	 * main function from which all call are invoked
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("--------------------------------------In mail class");
		MD5Genarator.generateMD5HashString("message", MESSAGE_DIGEST_ALGORITHM_TYPE.MD5);
	}

}
