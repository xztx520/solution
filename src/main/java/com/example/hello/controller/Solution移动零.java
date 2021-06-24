package com.example.hello.controller;

import java.util.Arrays;

/**
 * @description: com.example.hello.controller
 * @author: 喝咖啡的大象
 * @date: 2021/6/9
 */
public class Solution移动零 {
    //1. 重新开个新数组  loop  0放到J  非零放到I

    /**
     * 2. index  [0,1,0,10,100]
     * 时间复杂度 O(N)
     */
    public static void moveZeroes(int[] num) {
        //j记录非零元素
        int j = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                num[j] = num[i];
                if (i != j) {
                    num[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{0, 1, 0, 10, 100};
        moveZeroes(num);
        System.out.println(Arrays.toString(num));
    }
}
