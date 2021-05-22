package com.fh;

public class KaKaBrnan {

    int minEatingSpeed(int[] piles,int H){

        int max = getMax(piles);
        int left = 1;
        while (left < max){
            int mid = left + (max-left)/2;
            if(canFinal(piles,mid,H)){
                max = mid;
            }else{
                left = mid +1;
            }
        }
        return left;
    }

    private boolean canFinal(int[] piles, int mid, int h) {
        int time = 0;
        for (int pile : piles) {
            time += timeOf(mid,pile);
        }
        return time <=h;
    }

    private int timeOf(int mid, int pile) {
        return (pile/mid)+(pile % mid > 0 ? 1:0);
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max,pile);
        }
        return max;
    }














}
