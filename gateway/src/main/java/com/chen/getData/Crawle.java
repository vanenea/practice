package com.chen.getData;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;


public class Crawle implements Runnable {

	private HttpClient client =HttpClientBuilder.create().build();
	
	public void run() {
		HttpGet get = new HttpGet("http://www.baidu.com/s?wd=intitle:app&tn=json&rn=50");
		get.setHeader("userAgent", "Mozilla/5.0 (Windows NT 6.1; rv:16.0) Gecko/20100101 Firefox/16.0");
		get.setHeader("Content-Type", "application/x-www-form-urlencoded");
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entiry = response.getEntity();
			String str = EntityUtils.toString(entiry, "utf-8");
			JSONObject obj = JSONObject.parseObject(str);
			System.out.println("obj:"+obj);
			System.out.println(obj.get("entry"));;
			System.out.println(str);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i=0;i<1;i++) {
			new Thread(new Crawle()).start();
		}
	}
}
