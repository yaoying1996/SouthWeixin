package com.south.util;

import java.security.MessageDigest;
import java.util.Arrays;

public class SHA1 {
	 
	/**
	 * ��SHA1�㷨���ɰ�ȫǩ��
	 * @param token Ʊ��
	 * @param timestamp ʱ���
	 * @param nonce ����ַ���
	 * @param encrypt ����
	 * @return ��ȫǩ��
	 * @throws AesException 
	 */
	public static String getSHA1(String token, String timestamp, String nonce, String encrypt) throws AesException
			  {
		try {
			String[] array = new String[] { token, timestamp, nonce, encrypt };
			return sha1Comm(array);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ComputeSignatureError);
		}
	}
	
	/**
	 * ��SHA1�㷨���ɰ�ȫǩ��
	 * @param token Ʊ��
	 * @param timestamp ʱ���
	 * @param nonce ����ַ���
	 * @return ��ȫǩ��
	 * @throws AesException 
	 */
public static String getSHA1(String token, String timestamp, String nonce) throws AesException {
	try {
		String[] array = new String[] { token, timestamp, nonce};
		return sha1Comm(array);
	} catch (Exception e) {
		e.printStackTrace();
		throw new AesException(AesException.ComputeSignatureError);
		}
}
 
private static String  sha1Comm (String[] array ) throws Exception{
	StringBuffer sb = new StringBuffer();
	// �ַ�������
	Arrays.sort(array);
	for (int i = 0; i < array.length; i++) {
		sb.append(array[i]);
	}
	String str = sb.toString();
	// SHA1ǩ������
	MessageDigest md = MessageDigest.getInstance("SHA-1");
	md.update(str.getBytes()); //��������
	byte[] digest = md.digest();
 
  return	MD5Util.byteArrayToHexString(digest);
 
}
 
}

