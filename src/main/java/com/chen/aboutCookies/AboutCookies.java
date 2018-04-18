package com.chen.aboutCookies;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class AboutCookies {
	
	
	
	public static void main(String[] args) {
		HttpClient client = HttpClientBuilder.create().build(); 
		HttpClientContext context = HttpClientContext.create();
		
		HttpPost post = new HttpPost("http://localhost:8080/cp/admin1/admin.do");
		post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36");
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		List<NameValuePair> nameValue = new ArrayList<>();
		nameValue.add(new BasicNameValuePair("name", "wch"));
		nameValue.add(new BasicNameValuePair("pass", "123"));
		try {
			UrlEncodedFormEntity form = new UrlEncodedFormEntity(nameValue,"UTF-8");
			post.setEntity(form);
			HttpResponse response = client.execute(post, context);
			Header[] redirect = response.getAllHeaders();
			for (Header header : redirect) {
				System.out.println(header.getName()+":"+header.getValue());
			}
			
			CookieStore cookies = context.getCookieStore();
			System.out.println("cookies:"+cookies);
			System.out.println("context:"+context);
			System.out.println("response:"+EntityUtils.toString(response.getEntity(),"utf-8"));
			HttpGet get = new HttpGet("http://localhost:8080/cp/admin1/index.do");
			HttpResponse r = client.execute(get,context);
			System.out.println("index:"+EntityUtils.toString(r.getEntity(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
