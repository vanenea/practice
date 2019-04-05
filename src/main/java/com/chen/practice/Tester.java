package com.chen.practice;

public class Tester {

	public static void main(String[] args) throws Exception {
		
		System.out.println(reverse2(-5293));
		
		//System.out.println(Integer.parseInt("9646324351", 32));
		System.out.println(Integer.MAX_VALUE);
		int a = 9;
		System.out.println((a /=10));
	}
	
	public static int reverse(int x) {
        boolean negative = false;
        if(x<0){
            negative = true;
        }    

        String[] strs = Integer.toString(x).split("");
        for(int i=0; i<strs.length/2; i++){
            if(negative){
                String temp = strs[i+1];
                strs[i+1] = strs[strs.length-i-1];
                strs[strs.length-i-1] = temp;
            } else {
                String temp = strs[i];
                strs[i] = strs[strs.length-i-1];
                strs[strs.length-i-1] = temp;
            }
        }
        String str = "";
        for(int i=0; i<strs.length; i++){
            str += strs[i];
        }
        
        return Integer.parseInt(str);
        
    }
	
	   public static int reverse2(int x) {
	        int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            x /= 10;
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
	            rev = rev * 10 + pop;
	        }
	        return rev;
	    }
}
