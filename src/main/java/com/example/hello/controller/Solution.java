package com.example.hello.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: com.example.hello.controller
 * @company:
 * @author: 喝咖啡的大象
 * @date: 2021/3/25
 */
public class Solution {
    /**
     * 暴力枚举
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i);
                    System.out.println(j);
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * hash表算
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumHash(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> integerMap = new HashMap<>(len - 1);
        integerMap.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            int another = target - nums[i];
            if (integerMap.containsKey(another)) {
                System.out.println(i);
                System.out.println(integerMap.get(another));
                return new int[]{i, integerMap.get(another)};
            }
            integerMap.put(nums[i], i);
        }
        return null;
    }

    /**
     * 双指针找出不含有重复字符的最长子串的长度
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 无序重复字段的最长子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringk(String s) {
        int[] m = new int[128];
        int len = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            i = Math.max(m[s.charAt(j)], i);
            len = Math.max(len, j - i + 1);
            m[s.charAt(j)] = j + 1;
        }
        return len;
    }

    /**
     * 二分查找俩个数组的中位数
     * @param num1
     * @param num2
     * @return
     */
    public static double  findMedianSortedArrays(int[] num1,int[] num2){

        return 0.2;
    }

    /**
     * 字符串去重
     * @param s
     * @return
     */
    public static String  removeRepeatChar(String s){
        if (s==null){
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i=0;
        int len=s.length();
        while(i<len){
            char c = s.charAt(i);
            stringBuffer.append(c);
            i++;
            while (i<len && s.charAt(i)==c){
                i++;
            }
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 11, 15};
        int target = 16;
        twoSum(nums, target);
        System.out.println("------------------------");
        twoSumHash(nums, target);
        System.out.println("------------------------");
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println("------------------------");
        System.out.println(lengthOfLongestSubstringk("abedqbca"));
        System.out.println(removeRepeatChar("abeaaadssssdddddqbca"));
    }
}
