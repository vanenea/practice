package com.chen.practice;

public class Tester {

	public static void main(String[] args) throws Exception {
		Tester tester = new Tester();
		System.out.println(tester.removeDuplicates1(new int[] {1,1,2,3}));;
	}
	
	public int removeDuplicates(int[] nums) {
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
	
	
	 public int removeDuplicates1(int[] nums) {
	        if(nums.length == 0) return 0;
	        int j = nums.length;
	        for(int i=0; i<nums.length; i++){
	            if(i<nums.length-2 && nums[i]==nums[i+1]){
	                j--;
	            }
	        }
	        return j;
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
