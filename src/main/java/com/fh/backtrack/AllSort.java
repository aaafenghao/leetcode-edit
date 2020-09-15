package com.fh.backtrack;

import java.util.LinkedList;

/**
 * 全排列
 *
 * 算法模板
 * result = [];
 * void backtrace(路径,选择列表)
 *     if 满足条件
 *        result.add(路径)
 *     for 选择 in 选择列表
 *        做选择
 *        backtrace(路径,选择列表)
 *        撤销选择
 *
 */
public class AllSort {

    LinkedList<LinkedList<Integer>> result = new LinkedList<>();

    public void pre(int[] nums){
        LinkedList list = new LinkedList();
        backtrack(nums,list);
    }

    public void backtrack(int[] nums, LinkedList<Integer> track){
        if(nums.length == track.size()){
            result.add(track);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track);
            track.removeLast();
        }
    }


}
