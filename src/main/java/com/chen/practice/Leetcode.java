package com.chen.practice;

import static org.assertj.core.api.Assertions.in;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.formula.functions.Roman;

/**
 * leetcode算法题
 * @author Administrator
 *
 */
public class Leetcode {

	/**
	 * Given a 32-bit signed integer, reverse digits of an integer.
	 *	
	 *	Example 1:
	 *
	 *	Input: 123
	 *	Output: 321
	 *	
	 *	Example 2:
	 *		Input: -123
	 *		Output: -321
	 *		Example 3:
	 *
	 *		Input: 120
	 *		Output: 21
	 */
    public static int reverse(int x) {
    	int rev = 0;
    	while(x !=0) {
    		int pop = x%10;
    		x /= 10;
    		rev = rev*10+pop;
    	}
    	return rev;
    }
    
   /**
    * 回文
    *  Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

	    Example 1:
	
	    Input: 121
	    Output: true
	    Example 2:
	
	    Input: -121
	    Output: false
	    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
	    Example 3:
	
	    Input: 10
	    Output: false
	    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    */
    public boolean isPalindrome(int x) {
    	if(x<0) return false;
    	char[] arry = String.valueOf(x).toCharArray();
        for (int i = 0; i < arry.length/2; i++) {
			if(arry[i]!=arry[arry.length-i-1])
				return false;
		}
    	return true;
    }
    
    /**
     * 罗马数字 </br>
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M. <br>

		Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
		
		Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
		
		I can be placed before V (5) and X (10) to make 4 and 9. 
		X can be placed before L (50) and C (100) to make 40 and 90. 
		C can be placed before D (500) and M (1000) to make 400 and 900.
		Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<String, Integer> romanNumberals = new HashMap<String, Integer>();
        romanNumberals.put("I", 1);
        romanNumberals.put("V", 5);
        romanNumberals.put("X", 10);
        romanNumberals.put("L", 50);
        romanNumberals.put("C", 100);
        romanNumberals.put("D", 500);
        romanNumberals.put("M", 1000);
        
        romanNumberals.put("IV", 4);
        romanNumberals.put("IX", 9);
        romanNumberals.put("XL", 40);
        romanNumberals.put("XC", 90);
        romanNumberals.put("CD", 400);
        romanNumberals.put("CM", 900);
        int sum = 0;
        int index = -1;
        do {
        	if((index=s.indexOf("IV"))!=-1) {
        		s = s.replace("IV", "");
        		sum += 4;
        	}
        } while(index != -1);
        do {
        	if((index=s.indexOf("IX"))!=-1) {
        		s = s.replace("IX", "");
        		sum += 9;
        	}
        } while(index != -1);
        do {
        	if((index=s.indexOf("XL"))!=-1) {
        		s = s.replace("XL", "");
        		sum += 40;
        	}
        } while(index != -1);
        do {
        	if((index=s.indexOf("XC"))!=-1) {
        		s = s.replace("XC", "");
        		sum += 90;
        	}
        } while(index != -1);
        do {
        	if((index=s.indexOf("CD"))!=-1) {
        		s = s.replace("CD", "");
        		sum += 400;
        	}
        } while(index != -1);
        do {
        	if((index=s.indexOf("CM"))!=-1) {
        		s = s.replace("CM", "");
        		sum += 900;
        	}
        } while(index != -1);
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
        	sum += romanNumberals.get(String.valueOf(charArray[i]));
		}
        return sum;
    }
    
    
    
    public static void main(String[] args) {
		System.out.println(reverse(-123));
		System.out.println(romanToInt("MCMXCIV"));
		
	}
	
}
