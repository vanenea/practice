package com.chen.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Interview {

	/**
	 * 找出字符串中出现次数最多的字母和出现的次数
	 * 
	 * INPUT: "ithinkthisisastring'
	 * OUTPUT: {"i": 5}
	 * @param strs
	 * @return
	 */
	public static String findChar(String strs){
		char[] charArray = strs.toCharArray();
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		for (int i = 0; i < charArray.length; i++) {
			boolean index = true; 
			for (Character c : result.keySet()) {
				if(c.equals(charArray[i])) {
					result.put(c, result.get(c)+1);
					index = false;
					break;
				} 
				
			}
			if(index)
				result.put(charArray[i], 1);
		}
		
		Character max = null ;
		boolean flag = true;
		for (Character c : result.keySet()) {
			if(flag) {
				max = c;
				flag = false;
				continue;
			}
			if(Integer.compare(result.get(max), result.get(c))<0) {
				max = c;
			}
		}
		return ("{\""+max+"\":"+result.get(max)+"}");
	}
	
	/**
	 * 输入一个字符串，找出其中最长且没有重复字符的子字符串，输出子字符串的长度
	 * INPUT: "abcabcabc" 	OUTPUT: 3	结果是"abc"
	 * INPUT: "bbbbb"		OUTPUT:	1	结果是"b"
	 * INPUT: "pwwkew"		OUTPUT: 3	结果是"wke"
	 * @return
	 */
	public static String longest(String str) {
		char[] charArray = str.toCharArray();
		int min=0,max=0;
		for (int i = 0; i < charArray.length; ) {
			Character before = charArray[i];
			boolean flag = true;
			for (int j = i+1; j < charArray.length; j++) {
				Character after = charArray[j];
				if(before.equals(after)) {
					if((max-min)<(j-i)) {
						min = i;
						max = j-1;
						i = j;
						flag = false;
						break;
						
					}
				} 
			}
			if(flag)
				++i;
		}
		if(max==0) {
			return (1+", 结果是\""+charArray[0]+"\"");
		}else {
			return ((max-min+1)+", 结果是\""+str.substring(min, max+1)+"\"");
		}
	}
	
	/**
	 * 输入一串字符串，字符串只包含如下字符："(",")","{","}","["和"]",判断输入的字符串是否符合括号严格闭合
	 * 括号严格闭合： 字符串中的括号按照顺序闭合。
	 * 如："()" "()[]{}" 合法
	 *    "(]" "([)]"不合法
	 * @param str
	 * @return
	 */
	public static String isLegal(String str) {
		 Pattern pattern = Pattern.compile("^[(|)|\\[|\\]|{|}]+$");
		 if(str.length()==1) {
			 return "非法";
		 }else if(pattern.matcher(str).find()) {
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; ) {
				Character c1 = charArray[i];
				
				for (int j = i+1; j < charArray.length; j++) {
					Character c2 = charArray[j];
					if(((Character)'(').equals(c1)) {
						if(((Character)'[').equals(c2) || ((Character)']').equals(c2) || ((Character)'{').equals(c2) || ((Character)'}').equals(c2) || ((Character)'(').equals(c2)) {
							return "非法";
						}
					} else if(((Character)'[').equals(c1)) {
						if(((Character)'[').equals(c2) || ((Character)')').equals(c2) || ((Character)'{').equals(c2) || ((Character)'}').equals(c2) || ((Character)'(').equals(c2)) {
							return "非法";
						}
					} else if(((Character)'{').equals(c1)) {
						if(((Character)'[').equals(c2) || ((Character)')').equals(c2) || ((Character)'{').equals(c2) || ((Character)']').equals(c2) || ((Character)'(').equals(c2)) {
							return "非法";
						}
					} else {
						i = j+1;
					}
				}
				
				
			}
			
		}else {
			System.err.println("输入的参数不合法");
		}
		return "合法";
	}
	
	public static void main(String[] args) {
		System.out.println(findChar("ithinkthisisastring"));
		System.out.println(longest("pwwkew"));
		System.out.println(isLegal("([)"));
	}
}
