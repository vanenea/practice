package com.chen.practice;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Tester {

	public static void main(String[] args) throws Exception {
		String xmlstr = jsonToXml("{\"class\": {\"student\": [{\"age\": \"18\",\"gender\": \"男\",\"name\": \"张三\",\"qk\": [{\"q1\": \"001\",\"q2\": \"002\",\"q3\": \"003\"},{\"q1\": \"001\",\"q2\": \"002\",\"q3\": \"003\"}]},{\"age\": \"17\",\"gender\": \"男\",\"name\": \"李四\",\"qk\": {\"q1\": \"005\",\"q2\": \"006\",\"q3\": \"007\"}},{\"age\": \"19\",\"gender\": \"女\",\"name\": \"王五\",\"qk\": {\"q1\": \"008\",\"q2\": \"009\",\"q3\": \"010\"}}]}}");
        System.out.println(xmlstr);
	}
	
	 /**
     * Json to xml string.
     *
     * @param json the json
     * @return the string
     */
    public static String jsonToXml(String json){
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            JSONObject jObj = JSON.parseObject(json);
            jsonToXmlstr(jObj,buffer);
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
 
 
    /**
     * Json to xmlstr string.
     *
     * @param jObj   the j obj
     * @param buffer the buffer
     * @return the string
     */
    public static String jsonToXmlstr(JSONObject jObj,StringBuffer buffer ){
        Set<Map.Entry<String, Object>> se = jObj.entrySet();
        for(Iterator<Map.Entry<String, Object>> it = se.iterator(); it.hasNext(); )
        {
            Map.Entry<String, Object> en = it.next();
            if(en.getValue().getClass().getName().equals("com.alibaba.fastjson.JSONObject")){
                buffer.append("<"+en.getKey()+">");
                JSONObject jo = jObj.getJSONObject(en.getKey());
                jsonToXmlstr(jo,buffer);
                buffer.append("</"+en.getKey()+">");
            }else if(en.getValue().getClass().getName().equals("com.alibaba.fastjson.JSONArray")){
                JSONArray jarray = jObj.getJSONArray(en.getKey());
                for (int i = 0; i < jarray.size(); i++) {
                    buffer.append("<"+en.getKey()+">");
                    JSONObject jsonobject =  jarray.getJSONObject(i);
                    jsonToXmlstr(jsonobject,buffer);
                    buffer.append("</"+en.getKey()+">");
                }
            }else if(en.getValue().getClass().getName().equals("java.lang.String")){
                buffer.append("<"+en.getKey()+">"+en.getValue());
                buffer.append("</"+en.getKey()+">");
            }
        }
        return buffer.toString();
    }
}
