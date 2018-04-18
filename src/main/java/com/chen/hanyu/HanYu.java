package com.chen.hanyu;

import static org.hamcrest.CoreMatchers.containsString;

import org.apache.commons.lang3.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class HanYu {

	
	public static String convert(String text,HanyuPinyinCaseType caseType,boolean isCapitalize) {
		if(StringUtils.isBlank(text))
			return "";
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		if(caseType!=null)
			format.setCaseType(caseType);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		char[] ca = StringUtils.trimToEmpty(text).toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : ca) {
			if(Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
				try {
					String[] tem = PinyinHelper.toHanyuPinyinStringArray(c, format);
					for (String string : tem) {
						System.out.println("string:"+string);
					}
					if(isCapitalize) {
						sb.append(StringUtils.capitalize(tem[0]));
					}else {
						sb.append(tem[0]);
					}
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				if(isCapitalize) {
					sb.append(StringUtils.capitalize(Character.toString(c)));
				}else {
					sb.append(Character.toString(c));
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = convert("乐飞网络", HanyuPinyinCaseType.UPPERCASE, false);
		System.out.println("str:"+str);
	}
}
