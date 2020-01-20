package com.chen.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * LeetCode算法题
 * @author Chen.Y
 *
 */
public class Leetcode {
	public static void main(String[] args) {
		System.out.println(reverse(-123));
		System.out.println(romanToInt("MCMXCIV"));
		System.out.println(longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
		System.out.println(removeDuplicates(new int[] {1,1,2,3,1}));
		System.out.println(removeDuplicatesTemp(new int[] {1,1,2,3,1}));
		int[] plusOne = plusOne(new int[] {9,9,9,9});
		for(int i=0; i<plusOne.length; i++) {
			System.out.print(plusOne[i]);
		}
		System.out.println("");
		generate(10);
		System.out.println(singleNumber(new int[] {10,186,-49,176,118,167,-61,189,6,-24,7,-93,71,112,187,45,-36,38,82,108,-46,112,51,165,-37,159,1,-53,7,38,90,181,-23,91,-42,172,-95,130,84,149,-47,68,126,-67,175,22,121,131,84,114,60,64,182,-75,-17,-71,69,-92,103,-91,-91,86,126,166,33,-36,-80,-37,118,-80,-18,127,36,-71,-82,-82,144,12,57,149,71,91,-83,-100,-30,45,186,16,-51,-72,-83,107,140,-97,-93,1,12,189,-61,-50,180,98,96,-29,193,167,57,-45,16,6,-76,4,109,-23,22,144,190,-97,193,-51,-99,-79,-47,142,107,175,109,121,190,90,34,32,63,-24,41,-53,41,89,130,-18,-99,103,86,127,-30,102,32,-49,181,-60,114,60,-29,182,-75,168,96,51,33,142,108,69,10,-57,166,48,82,161,-17,-50,102,63,-45,140,180,176,-95,36,-46,168,187,161,-72,-100,-42,165,-76,-67,89,159,64,34,98,4,-60,172,-79,68,48,131,-57}));
	}
	
	/**
	 * Count Primes
	 * Count the number of prime numbers less than a non-negative number, n.
	 * @param n
	 * @return
	 */
	public int countPrimes(int n) {
		int number = 2;
		int a = 0;
		if(n>=number) {
			
			for(int i = 1; i < number; i++) {
				number /
				
			}
		}
		n
    }
	/**
	 * happy number
	 * @param n
	 * @return
	 */
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		int squaer;
		while(set.add(n)) {
			squaer = 0;
			do {
				int a = n%10;
				squaer += (a*a);
				n = n/10;
			} while (n>0);
			if(squaer==1) 
				return true;
			else
				n = squaer;
		}
		return false;
	}
	 
	public static int singleNumber(int[] nums) {
		StringBuilder con = new StringBuilder();
		for(int i = 0; i < nums.length-1; i++ ) {
			if(con.indexOf("#"+String.valueOf(i) + "#")!=-1) continue;
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] == nums[j]) {
					con.append("#"+ j + "#");
					break;
				}
				if(j==nums.length-1) return nums[i];
			}
		}
		return nums[nums.length-1];
	}

	/*
	 *  Pascal's Triangle Easy
	 * Given a non-negative integer numRows, generate the first numRows of
	 * Pascal's triangle.
	 */    
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++ ) {
        	List<Integer> list = new ArrayList<Integer>();
        	if(i == 0) {
        		list.add(1);
        	} else {
        		
        		for(int j = 0; j<=result.get(i-1).size(); j++) {
        			if(j == 0 || j== result.get(i-1).size()) {
        				list.add(1);
        			} else {
        				List<Integer> list2 = result.get(i-1);
        				Integer a1 = list2.get(j-1);
        				Integer a2 = list2.get(j);
        				list.add(a1 + a2);
        			}
        		}
        		
        	}
        	result.add(list);
        }
        System.out.println(result);
        return result;
    }
	

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
	*
	*   Example 1:
	
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
    
    
	/**
	 * Write a function to find the longest common prefix string amongst an array of
	 * strings.</br></br>
	 * 
	 * If there is no common prefix, return an empty string "".
	 * <hr>
	 * Example 1:
	 * <code>
	 * Input: ["flower","flow","flight"] Output: "fl" Example 2:
	 * 
	 * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common
	 * prefix among the input strings.
	 *	</code>
	 */
    public static String longestCommonPrefix(String[] strs) {
       if(strs.length==0) return "";
       String prefix = strs[0];
       for (int i = 1; i < strs.length; i++) {
    	   while(strs[i].indexOf(prefix)!=0) {
    		   prefix = prefix.substring(0, prefix.length()-1);
    		   if(prefix.isEmpty())
    			   return "";
    	   }
       }
       return prefix;
    }
    
	/**
	 * <p>
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid. 
	 * </p>
	 * 
	 * <p>
	 * An input string is valid if:
	 * </p>
	 * <p>
	 * Open brackets must be closed by the same type of brackets. Open brackets must
	 * be closed in the correct order. Note that an empty string is also considered
	 * valid.
	 * </p>
	 */
    public boolean isValid(String s) {
    	 // Hash table that takes care of the mappings.
    	HashMap<Character, Character> mappings = new HashMap<Character, Character>();;
    	mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        // Initialize a stack to be used in the algorithm.
    	Stack<Character> stack = new Stack<Character>();
  		for (int i = 0; i < s.length(); i++) {
  			char c = s.charAt(i);
  			// If the current character is a closing bracket.
  			if (mappings.containsKey(c)) {
			// Get the top element of the stack. If the stack is empty, set a dummy value of '#'
  				char topElement = stack.empty() ? '#' : stack.pop();
				// If the mapping for this bracket doesn't match the stack's top element, return false.
				if (topElement != mappings.get(c)) {
					return false;
				}
		} else {
		  // If it was an opening bracket, push to the stack.
		      stack.push(c);
	    }
	  }
	
	  // If the stack still contains elements, then it is an invalid expression.
	  return stack.isEmpty();
    }
    
    /**
     * <h2>Remove Duplicates from Sorted Array </h2>
     * 
     * Given nums = [1,1,2],
	 *
	 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     *
	 *	It doesn't matter what you leave beyond the returned length.
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
    	Set<Number> set = new HashSet<Number>();
    	for (int i = 0; i < nums.length; i++) {
    		set.add(nums[i]);
		}
        return set.size();
    }
    
    public static int removeDuplicatesTemp(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
    }
   
    public static int[] plusOne(int[] digits) {
       for(int i=digits.length-1; i>=0; i--) {
    	   if(digits[i] != 9) {
    		   digits[i] ++ ;
    		   return digits;
    	   } else {
    		   digits[i] = 0;
    	   }
       }
       
      
	   int[] out = new int[digits.length+1];
	   for(int i=out.length-1; i>=0; i--) {
		   if(i==0) {
			   out[0]=1;
		   } else {
			   out[i] = digits[i-1];
		   }
		   
	   }
	   return out;
       
      
    }
    
    
	
}
