package com.example.demo;

import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;

import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;

@SpringBootTest
public class DemoApplicationTests {
	private char[] _UU64 = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] _UU32 = "0123456789abcdefghijklmnopqrstuv".toCharArray();
	@Test
	public void contextLoads() {
		System.out.println(StringUtils.containsAny("asdfsadf", "r","f"));
		long L = UUID.randomUUID().getMostSignificantBits();
        long R = UUID.randomUUID().getLeastSignificantBits();
		//System.out.println("789456");
        System.out.println("l:"+L);
        System.out.println("R:"+R);
        System.out.println("str"+pet(null));
	}

	
	public static String pet(String str) {
		System.out.println("petpet");
		assert str!=null;
		System.out.println("pet");
		System.out.println("petpet");
		return str;
		
	}
	

	public static void main(String[] args) {
		/*String str = "{page:\"Page\"}";
		Gson gson = new Gson();
		String str1 = gson.toJson(str);
		System.out.println(str1);
		JSONObject json = JSONObject.fromObject(str);
		System.out.println(json);*/
		
		try {
			System.out.println(enAes("string", "0123456789abcdef"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String enAes(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return new BASE64Encoder().encode(encryptedBytes);
     //   return new String(encryptedBytes,"utf-8");
	}
	
}
