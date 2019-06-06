package com.chen.practice;

import org.apache.commons.collections.comparators.ReverseComparator;

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
    public static void main(String[] args) {
		System.out.println(reverse(-123));
	}
	
}
