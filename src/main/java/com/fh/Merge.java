package com.fh;

public class Merge {

    public static int[] aux;


    public static void main(String[] args) {
        int[] nums = new int[]{10,5,-3,3,2};
        Merge.sort(nums);
    }

    public static void sort(int[] nums){
        aux = new int[nums.length];
        sort(nums,0,nums.length-1);
    }

    private static void sort(int[] nums,int lo,int hi){
        if(lo >= hi){
            return;
        }
        int mid = lo + (hi-lo)/2;//主要是为了防止溢出
        sort(nums,lo,mid);
        sort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }

    private static void merge(int[] nums,int lo,int mid,int hi){
        int i=lo,j=mid+1;
        for (int k = lo; k < hi; k++) {
            aux[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++) {
            if(i>mid){
                nums[k] = aux[j++];
            } else if(j > hi){
                nums[k] = aux[i++];
            } else if(aux[j] < aux[i]){
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }
}
