package com.fh.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 */
public class SonCollection {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subset(List<Integer> nums){
        List<Integer> track = new ArrayList<>();
        backtrack(nums,0,track);
        return result;
    }

    /**
     * 子集
     * @param nums
     * @param start
     * @param track
     */
    public void backtrack(List<Integer> nums,int start,List<Integer> track){
        result.add(track);
        for (int i = start; i < nums.size(); i++) {
                track.add(nums.get(i));
                backtrack(nums,i+1,track);
                track.remove(nums.get(i));
        }
    }

    /**
     * 组合
     * @param n
     * @param k
     * @param start
     * @param track
     */
    public void backtrack1(int n,int k,int start,List<Integer> track){
        //树的底部进行处理
        if(k == track.size()){
            result.add(track);
            return;
        }
        for (int i = start; i < n; i++) {
            track.add(i);
            backtrack1(n,k,i+1,track);
            track.remove(i);
        }
    }

    /**
     * 全排列,不可重复
     * @param nums
     * @param track
     */
    public void backtrack2(int[] nums, LinkedList<Integer> track){
        if(track.size() == nums.length){
            result.add(track);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack2(nums,track);
            track.removeLast();
        }
    }

}
