package com.fh;

/**
 * 二分查找
 *
 * 左边界,右边界
 */
public class TwoFind {

    /**
     * koko吃香蕉
     * 有N堆香蕉,每堆香蕉有pile[i]个
     * 警卫将要离开H个小时
     * koko可以决定自己吃香蕉的速度K,如果这堆香蕉小于K,这堆被吃完，如果大于K,等待下个小时吃
     * 计算koko想将香蕉吃完的最小速度
     *
     * @return
     */
    int minEatingSpeed(int[] piles,int H){
        int left = 0,right = getMax(piles);
        while (left < right){
            int mid = left + (right - left) / 2;
            if(canFinish(piles,H,mid)){
                right = mid ;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public boolean canFinish(int[] piles,int H,int speed){
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time +=timeOf(piles[i],speed);
        }
        return time <=H;
    }

    public int timeOf(int n,int speed){
        return n/speed + n%speed >0?1:0;
    }

    public int getMax(int[] piles){
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
           max =  Math.max(max,piles[i]);
        }
        return max;
    }

    /**
     * 货物运输
     * 向船上添加包裹，每天添加的数量不会超过船的载重
     * D天内运输完成，求船的最低运载能力
     * @param weights
     * @param D
     * @return
     */
    int shipWithinDays(int[] weights,int D){
        int left = getMax(weights);
        int right = getSum(weights) + 1;
        while (left < right){
            int mid = left + (right -left)/2;
            if(canFinishWei(weights,D,mid)){
              right = mid;
            }else{
                left = mid +1;
            }
        }
        return 0;
    }

    private boolean canFinishWei(int[] weights, int d, int mid) {
        int i = 0;
        for (int j = 0; j < d; j++) {
            int maxCap = mid;
            while ((maxCap -=weights[j]) >=0){
                i++;
                if(i == weights.length){
                    return true;
                }
            }
        }
        return false;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum +=weights[i];
        }
        return sum;
    }
}
