package com.chen.practice;

import java.util.*;

/**
 * LeetCode算法题
 *
 * @author Chen.Y
 */
public class Leetcode {
    static Map<Integer, Long> param = new HashMap<>();

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
        System.out.println(res);
    }

    static List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    public static List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    public static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static long fibBWL(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;

        if (param.get(n) != null) {
            return param.get(n);
        } else {
            param.put(n, fibBWL(n - 1) + fibBWL(n - 2));
            return param.get(n);
        }
    }

    public static long fib(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }


    public static int lengthOfLastWord1(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(" ") + 1;
        return s.length() - lastIndex;
    }

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
     * <p>
     * If the last word does not exist, return 0.
     * <p>
     * Note: A word is defined as a maximal substring consisting of non-space characters only.
     * <p>
     * Example:
     * <p>
     * Input: "Hello World"
     * Output: 5
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' != chars[i]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * <p>
     * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively,
     * in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder pre;
        for (int i = 1; i < n; i++) {


        }
        return curr.toString();
    }

    /**
     * Implement strStr().
     * <p>
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * <p>
     * Example 1:
     * <p>
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * <p>
     * Example 2:
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (chars1[j] != chars[i + j]) break;
            }
        }
    }


    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        for (int i = 0; i < rowIndex; i++) {
            //for (int j = ; j <; j++) {

            //}
            ret.add(1);
        }
        return ret;
    }

    /**
     * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
     * <p>
     * Note that the row index starts from 0.
     * <p>
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     */

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int tmp = ret.get(j - 1) + ret.get(j);
                ret.set(j, tmp);
            }
            ret.add(1);
        }
        return ret;
    }

    /**
     * Count Primes
     * Count the number of prime numbers less than a non-negative number, n.
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int number = 2;
        int a = 0;
        if (n >= number) {

            for (int i = 1; i < number; i++) {
                //number /

            }
        }
        return 0;
    }

    /**
     * happy number
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int squaer;
        while (set.add(n)) {
            squaer = 0;
            do {
                int a = n % 10;
                squaer += (a * a);
                n = n / 10;
            } while (n > 0);
            if (squaer == 1)
                return true;
            else
                n = squaer;
        }
        return false;
    }

    public static int singleNumber(int[] nums) {
        StringBuilder con = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            if (con.indexOf("#" + String.valueOf(i) + "#") != -1) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    con.append("#" + j + "#");
                    break;
                }
                if (j == nums.length - 1) return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /*
     *  Pascal's Triangle Easy
     * Given a non-negative integer numRows, generate the first numRows of
     * Pascal's triangle.
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if (i == 0) {
                list.add(1);
            } else {

                for (int j = 0; j <= result.get(i - 1).size(); j++) {
                    if (j == 0 || j == result.get(i - 1).size()) {
                        list.add(1);
                    } else {
                        List<Integer> list2 = result.get(i - 1);
                        Integer a1 = list2.get(j - 1);
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
     * <p>
     * Example 1:
     * <p>
     * Input: 123
     * Output: 321
     * <p>
     * Example 2:
     * Input: -123
     * Output: -321
     * Example 3:
     * <p>
     * Input: 120
     * Output: 21
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 回文
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     * <p>
     * Example 1:
     * <p>
     * Input: 121
     * Output: true
     * Example 2:
     * <p>
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     * <p>
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] arry = String.valueOf(x).toCharArray();
        for (int i = 0; i < arry.length / 2; i++) {
            if (arry[i] != arry[arry.length - i - 1])
                return false;
        }
        return true;
    }

    /**
     * 罗马数字 </br>
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M. <br>
     * <p>
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     *
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
            if ((index = s.indexOf("IV")) != -1) {
                s = s.replace("IV", "");
                sum += 4;
            }
        } while (index != -1);
        do {
            if ((index = s.indexOf("IX")) != -1) {
                s = s.replace("IX", "");
                sum += 9;
            }
        } while (index != -1);
        do {
            if ((index = s.indexOf("XL")) != -1) {
                s = s.replace("XL", "");
                sum += 40;
            }
        } while (index != -1);
        do {
            if ((index = s.indexOf("XC")) != -1) {
                s = s.replace("XC", "");
                sum += 90;
            }
        } while (index != -1);
        do {
            if ((index = s.indexOf("CD")) != -1) {
                s = s.replace("CD", "");
                sum += 400;
            }
        } while (index != -1);
        do {
            if ((index = s.indexOf("CM")) != -1) {
                s = s.replace("CM", "");
                sum += 900;
            }
        } while (index != -1);
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            sum += romanNumberals.get(String.valueOf(charArray[i]));
        }
        return sum;
    }


    /**
     * Write a function to find the longest common prefix string amongst an array of
     * strings.</br></br>
     * <p>
     * If there is no common prefix, return an empty string "".
     * <hr>
     * Example 1:
     * <code>
     * Input: ["flower","flow","flight"] Output: "fl" Example 2:
     * <p>
     * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common
     * prefix among the input strings.
     * </code>
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
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
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        ;
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
     * <p>
     * Given nums = [1,1,2],
     * <p>
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     * <p>
     * It doesn't matter what you leave beyond the returned length.
     *
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
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }


        int[] out = new int[digits.length + 1];
        for (int i = out.length - 1; i >= 0; i--) {
            if (i == 0) {
                out[0] = 1;
            } else {
                out[i] = digits[i - 1];
            }

        }
        return out;


    }


}
