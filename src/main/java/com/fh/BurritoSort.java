package com.fh;

import java.util.LinkedList;

/**
 * 烧饼排序
 *
 * 3 2 4 1 --烧饼大小
 * 4 2 4 3 --需要翻转的次数
 *
 *
 */
public class BurritoSort {

    LinkedList<Integer> result = new LinkedList<>();

    void sort(int[] nums,int n){
        if(n == 1){
            return;
        }
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > maxCake){
                maxCake = nums[i];
                maxCakeIndex = i;
            }
        }
        reveser(nums,0,maxCakeIndex);
        result.add(maxCakeIndex+1);
        reveser(nums,0,n-1);
        result.add(n);

        sort(nums,n-1);

        //翻转第一次
    }
    //锅铲铲烧饼,对应的数据都要翻转
    public void reveser(int[] nums,int i,int j){
        while (i<j){
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
            i++;j--;
        }
    }




}
