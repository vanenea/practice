package com.chen.algorithms;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.regex.Pattern;


public class StringUtil {
	
	public static String a = "";
	
	public static void main(String[] args) throws Exception {
		StringUtil su = new StringUtil();
		su.her();
	}
	
	
	public void parseXml(Map<String, Object> result){
		result.put("111", "000");
		result.put("222", "222");
		
	}
	
	
	public int i = 5;
	
	public int her(){
		if(i<1){
			System.out.println("exit!");
			return i;
		}
		i--;
		System.out.println("her:"+her());
		System.out.println(i);
		return i;
	}

	public static void parttern() {
		String str = "，。？！…~.哈哈还哈哈哈啊哈哈哈-；@：'\"“～、——\\(!％)”\"12658";
		str = str.trim();
		String replaceStr = str;
		
		 Pattern[] DANGEROUS_TOKENS = new Pattern[] { Pattern.compile(
				"^j\\s*a\\s*v\\s*a\\s*s\\s*c\\s*r\\s*i\\s*p\\s*t\\s*:",
				Pattern.CASE_INSENSITIVE) };
		 // javascript:替换字符串（全角中文字符）
		 String[] DANGEROUS_TOKEN_REPLACEMENTS = new String[] { "ＪＡＶＡＳＣＲＩＰＴ：" };
		 for (int i = 0; i < DANGEROUS_TOKENS.length; ++i) {
				replaceStr = DANGEROUS_TOKENS[i].matcher(str).replaceAll(
						DANGEROUS_TOKEN_REPLACEMENTS[i]);
			}
		 System.out.println(replaceStr);
	}
	
	private String getUrlParam(String url, String param){
		int indexParam = url.indexOf(param);
		if(StringUtils.isEmpty(param) || indexParam<0){
			return "";
		}
		int indexOf = url.indexOf("&", indexParam);
		if(indexOf<0){
			return url.substring(indexParam+param.length()+1);
		} else {
			return url.substring(indexParam+param.length()+1, indexOf);
		}
	}
}
