package com.example.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class service_Wxservice{
	private static String TOKEN="abc";
	
	public static boolean check(String singnature, String timestamp, String nonce) {
		// 将token,timestamp,nonce进行字典排序
		String[] strs = new String[] { TOKEN, timestamp, nonce };
		Arrays.sort(strs);
		System.out.println(timestamp);
		System.out.println(nonce);

		// 将三个参数拼接成一个字符串进行sha1加密
		String str = strs[0] + strs[1] + strs[2];
		String mysig = sha1(str);
		// 开发者获取的字符串与singnature进行对比，标识请求来源于微信
		System.out.println(mysig);
		System.out.println(singnature);

		return mysig.equalsIgnoreCase(singnature);

	}
	public static String sha1(String str)
	{
		//获取加密对象
				try {
					MessageDigest md = MessageDigest.getInstance("sha1");
					// 加密
					byte[] bytes = md.digest(str.getBytes());
					char[] s = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
					StringBuffer sb = new StringBuffer();
					System.out.println(str);
					for (byte b : bytes) {
						System.out.println(b);
						sb.append(s[(b >> 4) & 15]);
						sb.append(s[b & 15]);
					}

					return sb.toString();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return null;
	}

}