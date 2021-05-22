package com.fh;

import java.util.Map;

/**
 * 接雨水为题
 */
public class GetRain {



    int trap(int[] height){
        int length = height.length;
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            int l_max = 0;
            int r_max = 0;
            for (int j = i; j < length; j++) {
                r_max = Math.max(r_max,height[j]);
            }
            for (int j = i; j >=0 ; j--) {
                l_max = Math.max(l_max,height[j]);
            }
            ans += Math.min(l_max,r_max)-height[i];
        }
        return ans;
    }


    int trap1(int[] height){
        if(height.length == 0){
            return 0;
        }
        int n = height.length;
        int ans = 0;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n-1] = height[n-1];
        for (int i = 1; i <n; i++) {
            l_max[i] = Math.max(height[i],l_max[i-1]);
        }
        for (int i = n-2; i >=0 ; i--) {
            r_max[i] = Math.max(height[i],r_max[i+1]);
        }
        for (int i = 1; i < n-1; i++) {
            ans += Math.min(l_max[i],r_max[i]) -height[i];
        }
        return ans;
    }

    int trap2(int[] height){
        if(height.length == 0){
            return 0;
        }

        int n = height.length;
        int left = 0;
        int right = n-1;
        int ans = 0;
        int l_max = height[0];
        int r_max = height[n-1];
        while (left < right){
            l_max = Math.max(l_max,height[left]);
            r_max = Math.max(r_max,height[right]);
            if(l_max < r_max){
                ans += l_max - height[left];
                left++;
            }else{
                ans += r_max - height[right];
                right++;
            }
        }
        return ans;
    }
}
