package com.chen.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Test{
	GOOD,MORNING,YOU,ARE,RIGHT
}

public class Reg {
	Test test;
	public Reg(Test test) {
		this.test = test;
	}
	@Override
	public String toString() {
		return "test is "+test;
	}

	public static void main(String[] args) {
		/*Pattern pa = Pattern.compile(".*[^(mp4) | ^(mp3)]+");
		Matcher ma = pa.matcher("sdfdsfwemp345");
		System.out.println(ma.matches());*/
		/*System.out.println(new Reg(Test.GOOD));
		System.out.println(new Reg(Test.MORNING));
		
		String[] str = splitSentence("【华夕网络11.11双十一优惠大酬宾，低价建站，速来围观】上海网站建设 - 上海华夕网络科技有限公司");
		for (String string : str) {
			System.out.println(string);
		}*/
		
		Matcher matcher = java.util.regex.Pattern.compile("\\w").matcher("51561wewe15611fg");
		if(matcher.lookingAt()) {
			System.out.println(matcher.start()+","+matcher.end());
		}
	}
	
	/** 
     * 根据标点符号进行句子拆分，并且保留句子结尾符号 
     *  
     */  
    public static String[] splitSentence(String cmt){  
        /*正则表达式：句子结束符*/    
        String regEx=",|\\?|!|:|;|~|，|：|。|！|；|？|-";      
        Pattern p =Pattern.compile(regEx);     
        Matcher m = p.matcher(cmt);     
        /*按照句子结束符分割句子*/    
        String[] words = p.split(cmt);     
        /*将句子结束符连接到相应的句子后*/    
        if(words.length > 0)     
        {     
            int count = 0;     
            while(count < words.length)     
            {     
                if(m.find())     
                {     
                    words[count] += m.group();     
                }     
                count++;     
            }     
        }     
        /*输出结果*/    
        return words;  
    }  
}
