package com.chen.testWeb;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Do implements Runnable {
	HttpClient client = HttpClientBuilder.create().build();
	static int count = 0;
	public static void main(String[] args) {
		while(true) {
			for (int i = 0; i < 100; i++) {
				new Thread(new Do()).start();
				count++;
				System.err.println(">>>>>>>>第"+count+"次访问<<<<<<<");
			}
			try {
				Thread.sleep(1000*60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		HttpGet get = new HttpGet("http://www.chenlaoshi.top");
		get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36");
		try {
			HttpResponse response = client.execute(get);
			String str = EntityUtils.toString(response.getEntity(),"UTF-8");
			System.err.println(str.substring(0, 50));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
