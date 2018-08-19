package com.chen.work;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Demo {

	public static void main(String[] args) {
		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("firstId", "1");
		jo.put("firstTitle", "一级标题1");
		jo.put("secondId", "50");
		jo.put("secondTitle", "二级标题1");
		jo.put("thirdId", "100");
		jo.put("thirdTitle", "三级标题1");
		ja.add(jo);
		jo = new JSONObject();
		jo.put("firstId", "1");
		jo.put("firstTitle", "一级标题2");
		jo.put("secondId", "50");
		jo.put("secondTitle", "二级标题2");
		jo.put("thirdId", "101");
		jo.put("thirdTitle", "三级标题2");
		ja.add(jo);
		jo = new JSONObject();
		jo.put("firstId", "1");
		jo.put("firstTitle", "一级标题3");
		jo.put("secondId", "50");
		jo.put("secondTitle", "二级标题3");
		jo.put("thirdId", "102");
		jo.put("thirdTitle", "三级标题3");
		ja.add(jo);
		jo = new JSONObject();
		jo.put("firstId", "1");
		jo.put("firstTitle", "一级标题4");
		jo.put("secondId", "60");
		jo.put("secondTitle", "二级标题4");
		jo.put("thirdId", "103");
		jo.put("thirdTitle", "三级标题4");
		ja.add(jo);
		jo = new JSONObject();
		jo.put("firstId", "1");
		jo.put("firstTitle", "一级标题5");
		jo.put("secondId", "60");
		jo.put("secondTitle", "二级标题5");
		jo.put("thirdId", "104");
		jo.put("thirdTitle", "三级标题5");
		ja.add(jo);
		jo = new JSONObject();
		jo.put("firstId", "1");
		jo.put("firstTitle", "一级标题6");
		jo.put("secondId", "71");
		jo.put("secondTitle", "二级标题6");
		jo.put("thirdId", "105");
		jo.put("thirdTitle", "三级标题6");
		ja.add(jo);
		jo = new JSONObject();
		jo.put("firstId", "1");
		jo.put("firstTitle", "一级标题7");
		jo.put("secondId", "71");
		jo.put("secondTitle", "二级标题7");
		jo.put("thirdId", "106");
		jo.put("thirdTitle", "三级标题7");
		ja.add(jo);
		System.out.println(ja.toJSONString());
		String str = ja.toJSONString(); 
		
		List<SecondList> data = new ArrayList<SecondList>();
		JSONArray jaa = JSON.parseArray(str);
		for (int i = 0; i < jaa.size(); i++) {
			jo = JSON.parseObject(jaa.getString(i));
			ThirdList tl = new ThirdList();
			tl.setId(jo.getString("thirdId"));
			tl.setTitle(jo.getString("thirdTitle"));
			
			if(data.size()<=0) {
				SecondList sl = new SecondList();
				sl.setId(jo.getString("secondId"));
				sl.setTitle(jo.getString("secondTitle"));
				sl.getList().add(tl);
				data.add(sl);
				continue;
			}
			String secondId = jo.getString("secondId");
			ListIterator<SecondList> listIterator = data.listIterator();
			boolean flag = true;
			while(listIterator.hasNext()) {
				SecondList s = listIterator.next();
				if(s.getId().equals(secondId)) {
					flag = false;
					s.getList().add(tl);
					break;
				}
			}
			if(flag) {
				SecondList sl = new SecondList();
				sl.setId(secondId);
				sl.setTitle(jo.getString("secondTitle"));
				sl.getList().add(tl);
				listIterator.add(sl);
			}
		}
		JSONObject jj = new JSONObject();
		jj.put("code", "000000");
		jj.put("msg", "查询成功");
		jj.put("data", data);
		System.out.println(jj);
		
	}
}
