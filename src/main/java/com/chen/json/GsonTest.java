package com.chen.json;

import com.chen.domain.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.google.gson.JsonParser;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * google Json Operation
 */
public class GsonTest {

	public static void main(String[] args) {
		List<User> userList = new ArrayList<>();
		User user1 = new User();
		user1.setId(1);
		user1.setUsername("chen");
		user1.setPassword("123456");

		User user2 = new User();
		user2.setId(1);
		user2.setUsername("chen");
		user2.setPassword("123456");
		userList.add(user1);
		userList.add(user2);

		Map<String, Object> map = new HashMap<>();
		map.put("data",userList);
		//google的gson
		Gson gson = new Gson();
		String str = gson.toJson(map);

		JsonObject json = new JsonParser().parse(str).getAsJsonObject();
		System.out.println("str:"+str);

		JsonArray ja = new JsonParser().parse(json.get("data").toString()).getAsJsonArray();

		System.out.println("ja:"+ja);

		//sf的json
		JSONObject jsonObject =JSONObject.fromObject(user1);
		System.out.println("jsonToString:"+jsonObject.toString());
		System.out.println(jsonObject.get("username"));
		
	}
}
