package com.chen.algorithms;

import java.io.FileOutputStream;

import com.alibaba.fastjson.JSONObject;
import com.nbcb.mobileoa.common.util.HttpUtil;

public class DownloadFile {

	public static void main(String[] args) {
		try {
			HttpUtil httpUtil = new HttpUtil("http://12.99.136.245:9000/sjjk/downfiles");
			httpUtil.set_encode("utf-8");
			JSONObject jo = new JSONObject();
			jo.put("fjid", "6286fabd5362434085f60d8d6e07e515");
			String response = httpUtil.post(jo.toJSONString());
			byte[] b = response.getBytes("utf-8");
			FileOutputStream out = new FileOutputStream("/uploadFile/logo.png");
			out.write(b);
			out.flush();
			out.close();
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
