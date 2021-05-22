package com.fh;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和
 *   3 5 2 -2 4 1
 * 0 3 8 10 8 12 13
 */
public class PrefixAnd {

    int subarraySum(int[] nums,int k){
        int n = nums.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i]+nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(sum[i] - sum[j] == k){
                    ans++;
                }
            }
        }
        return ans;
    }

    int subarraySum1(int[] nums,int k){
        int n = nums.length;
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int ans = 0;
        int sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i +=nums[i];
            int sum0_j = sum0_i-k;
            if(preSum.containsKey(sum0_j)){
                ans+=preSum.get(sum0_i);
            }
            preSum.put(sum0_i,preSum.getOrDefault(sum0_i,0)+1);
        }
        return ans;
    }
}
