package com.chen.practice;

import java.net.HttpURLConnection;
import java.net.URL;

public class Tester {

	public static void main(String[] args) throws Exception {
		URL url = new URL("https://chenlaoshi.top");
		HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
		
	}
}
