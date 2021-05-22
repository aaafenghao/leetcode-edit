package com.fh;

/**
 * 货物运输
 *
 * 一次最少运输多少获取，才能在d天运输完成
 */
public class ShipGoods {

    int shipWithDay(int[] weights, int d){
        int left = getMax(weights);
        int right = getSum(weights);
        while (left < right){
            int mid = left + (right - left)/2;
            if(canFinish(weights,mid,d)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] weights, int mid, int d) {
        int i = 0;
        for (int day = 0; day < d; day++) {
            int maxCap = mid;
            while ((maxCap -=weights[i]) >= 0){
                i++;
                if(i == weights.length){
                    return true;
                }
            }
        }
        return false;
    }

    private int getSum(int[] weights) {
        return 0;
    }

    private int getMax(int[] weights) {
        return 0;
    }


}
