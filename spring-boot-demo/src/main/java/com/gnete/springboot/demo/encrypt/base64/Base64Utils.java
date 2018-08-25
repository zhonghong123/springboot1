package com.gnete.springboot.demo.encrypt.base64;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * base64算法编码与解码
 * 
 * @author hong
 *
 */
public class Base64Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(Base64Utils.class);

	/**
	 * base64编码：将字节数据转成字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String encode(byte[] bytes){
		return new BASE64Encoder().encode(bytes);
	}
	
	/**
	 * base解码：将base64字符串解码成字节数组
	 * 
	 * @param s
	 * @return
	 * @throws IOException
	 */
	public static byte[] decode(String s) throws IOException{
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(s);
	}
	
	public static void main(String[] args) throws IOException {
		String str = "abcd小茗同学￥%……";
		logger.info(str);
		//编码传输
		byte[] bytes = str.getBytes("GBK");
		logger.info("bytes length is {}", bytes.length);
		String encoder = Base64Utils.encode(bytes);
		logger.info("base64编码后字符串-->{}", encoder);
		
		bytes = Base64Utils.decode(encoder);
		logger.info("bytes length is {}", bytes.length);
		logger.info("base64解码后字符串-->{}", new String(bytes, "GBK"));
	}
}
