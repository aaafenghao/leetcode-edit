package com.fh;

/**
 * 接雨水
 *
 * 给你一个数组,根据数组里边的数字判断能接受多少雨水
 *
 */
public class ReceiveRainWater {

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    int trap(int[] nums){
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l_max = 0;
            int r_max = 0;
            for (int j = i; j < n ; j++) {
                r_max = Math.max(r_max,nums[i]);
            }
            for (int j = i; j >=0 ; j--) {
                l_max = Math.max(l_max,nums[i]);
            }
            ans +=Math.min(l_max,r_max) - nums[i];
        }

        return ans;
    }

    /**
     * dp 数组
     * @param nums
     * @return
     */
    int trap1(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int length = nums.length;
        int ans = 0;
        int[] l_max = new int[length];
        int[] r_max = new int[length];
        l_max[0] = nums[0];
        r_max[length-1] = nums[length-1];
        for (int i = 1; i < length; i++) {
            l_max[i] = Math.max(nums[i],l_max[i-1]);
        }
        for (int i = length-2; i >=0 ; i--) {
            r_max[i] = Math.max(nums[i],r_max[i+1]);
        }
        for (int i = 1; i < length-1; i++) {
            ans +=Math.min(l_max[i],r_max[i]) - nums[i];
        }
        return ans;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    int trap2(int[] nums){
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int  ans = 0;

        int l_max = nums[0];
        int r_max = nums[length - 1];
        while (left <= right){
            l_max = Math.max(l_max,nums[left]);
            r_max = Math.max(r_max,nums[right]);

            if(l_max < r_max){
                ans += l_max - nums[left];
                left++;
            }else {
                ans += r_max - nums[right];
                right--;
            }
        }
        return ans;
    }
}
