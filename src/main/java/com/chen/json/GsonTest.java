package com.chen.json;

import com.chen.domain.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import net.sf.json.JSONObject;

public class GsonTest {

	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setUsername("chen");
		user.setPassword("123456");
		
		//google的gson
		Gson gson = new Gson();
		String str = gson.toJson(user);
		JsonObject json = new JsonObject();
		System.out.println("str:"+str);
		
		//sf的json
		JSONObject jsonObject =JSONObject.fromObject(user);
		System.out.println("jsonToString:"+jsonObject.toString());
		System.out.println(jsonObject.get("username"));
		
	}
}
