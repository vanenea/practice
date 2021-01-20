package com.chen.algorithms;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eos.runtime.core.TraceLoggerFactory;
import com.eos.system.exception.EOSException;
import com.eos.system.logging.Logger;
import com.nbcb.mobileoa.common.util.HttpUtil;
import com.nbcb.mobileoa.common.util.XmlUtil;

/**
 * 与ESB交互的工具类.
 * @author k3762-Chen.Yan
 * @date 2019.12.31 
 */
public class ESBUtil {

	/**
	 * 日志
	 */
	private static final Logger LOGGER = TraceLoggerFactory
			.getContributionTraceLogger("com.nbcb.mobileoa.retail", ESBUtil.class);
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> post(String url, String params, Map<String, Object> param, String title, String description) throws EOSException {
		LOGGER.info("###### " + title + " >>> " + description + " WEB Params : " + params + "+++++ \n" + param + " ######");
		
		String request = parseXML(params, param);
		String response;
		try {
			HttpUtil httpUtil = new HttpUtil(url);
			httpUtil.set_encode("UTF-8");
			LOGGER.info("###### " + title + " >>> " + description + " URL : " + url + " ######");
			LOGGER.info("###### " + title + " >>> " + description + " request : " + request + " ######");;
			response = httpUtil.post(request);
			LOGGER.info("###### " + title + " >>> " + description + " response : " + response + " ######");
		} catch (Exception e) {
			LOGGER.error("###### " + title + " >>> 网络异常 ######", e);
			throw new EOSException("1000", "网络异常");
		}
		try {
			//解析响应报文
			Map<String, Object> decode = XmlUtil.decode(response);
			return decode;
		} catch (Exception e){
			LOGGER.error("######  " + title + " >>> 数据异常 ######", e);
			throw new EOSException("2000", "数据异常");
		}
	}
	
	/**
	 * JSON或Map解析为XML以字符串返回. 默认XML根目录为xml
	 * @param params JSON字符串
	 * @param param  Map参数
	 * @return
	 */
	public String parseXML(String params, Map<String, Object> param){
		return parseXML(params, param, "xml");
	}
	
	/**
	 * 
	 * JSON或Map解析为XML以字符串返回. 自定义XML根目录为
	 * @param params JSON字符串
	 * @param param  Map参数
	 * @param rootName  根目录名称
	 * @return
	 */
	public String parseXML(String params, Map<String, Object> param, String rootName){
		if(StringUtils.isBlank(params) && (param == null || param.isEmpty()))	return "";
		Document doc = DocumentHelper.createDocument();
		doc.setXMLEncoding("UTF-8");
		Element root = doc.addElement(rootName);
		if(!StringUtils.isBlank(params) && !"{}".equals(params)){
			json2xml(JSON.parseObject(params), root);
		}
		if(param!=null && !param.isEmpty()){
			for(Entry<String, Object> entry : param.entrySet()){
				root.addElement(entry.getKey()).addText((String)entry.getValue());
			}
		}
		return doc.asXML();
	}
	/**
	 * 将JSON解析为XML
	 * @param jObj
	 * @param ele
	 */
	public void json2xml(JSONObject jObj, Element ele){
		Set<Entry<String, Object>> se = jObj.entrySet();
        for(Iterator<Entry<String, Object>> it = se.iterator(); it.hasNext();) {
            Entry<String, Object> en = it.next();
            if("com.alibaba.fastjson.JSONObject".equals(en.getValue().getClass().getName())){
            	Element e = ele.addElement(en.getKey());
                JSONObject jo = jObj.getJSONObject(en.getKey());
                json2xml(jo,e);
            }else if("com.alibaba.fastjson.JSONArray".equals(en.getValue().getClass().getName())){
                JSONArray jarray = jObj.getJSONArray(en.getKey());
                for (int i = 0; i < jarray.size(); i++) {
                	Element e = ele.addElement(en.getKey());
                    JSONObject jsonobject =  jarray.getJSONObject(i);
                    json2xml(jsonobject,e);
                }
            }else if("java.lang.String".equals(en.getValue().getClass().getName())){
            	ele.addElement(en.getKey()).addText((String)en.getValue());
            }
        }
	
	}
	
	public static void main(String[] args) {
		ESBUtil ESBUtil = new ESBUtil();
		JSONObject jo = JSON.parseObject("{\"world\": {\"Asia\": [{\"age\": \"5000\",\"area\": \"960\",\"name\": \"China\",\"acd\": [{\"a\": \"001\",\"b\": \"002\",\"c\": \"003\"},{\"a\": \"001\",\"b\": \"002\",\"c\": \"003\"}]},{\"age\": \"17\",\"area\": \"23\",\"name\": \"Jpan\",\"acd\": {\"a\": \"005\",\"b\": \"006\",\"c\": \"007\"}},{\"age\": \"19\",\"area\": \"26\",\"name\": \"Korea\",\"acd\": {\"a\": \"008\",\"b\": \"009\",\"c\": \"010\"}}]}}");
		System.out.println(jo.toJSONString());
		Document doc = DocumentHelper.createDocument();
		doc.setXMLEncoding("UTF-8");
		Element root = doc.addElement("xml");
		ESBUtil.json2xml(jo, root);
		System.out.println(doc.asXML());
	}
}
