package com.fh;

import java.util.Arrays;

/**
 * 如何运用贪心思想玩跳跃游戏
 *
 *
 */
public class JumpingGames {

    /**
     * Jump Games I
     * @param nums
     * @return
     */
    boolean canJump(int[] nums) {
        int length = nums.length;
        int farthest = 0;
        for (int i = 0; i < length-1; i++) {
            farthest = Math.max(farthest,i+nums[i]);
            if(farthest <= i){//卡住了
                return false;
            }
        }
        return farthest >= length - 1;
    }


    /**
     * Jump Games II
     * 求最小的跳跃次数
     *
     * 动态规划
     *
     * @param nums
     * @return
     */
    int[] dp;

    int canJump1(int[] nums){
        int length = nums.length;
        dp = new int[length];
        Arrays.fill(dp,length);
        return 0;
    }

    int dp(int[] nums,int p){
        int length = nums.length;
        if(p >= length-1){
            return 0;
        }
        //重复子问题去重
        if(dp[p] != length){
            return dp[p];
        }

        int steps = nums[p];
        for (int i = 0; i < steps; i++) {
            int subProblem = dp(nums,p+i);
            dp[p] = Math.min(dp[p],subProblem+1);
        }
        return dp[p];
    }


}
