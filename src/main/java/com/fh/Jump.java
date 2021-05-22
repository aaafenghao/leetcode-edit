package com.fh;

public class Jump {

    boolean canJump(int[] nums){
        int farthest = 0;
        for (int i = 0; i < nums.length-1; i++) {
            farthest  = Math.max(farthest,nums[i]+i);
            if(farthest <=i){
                return false;
            }
        }
        return farthest >= nums.length -1;
    }

    /**
     * 3-1-4-2
     *
     * @param nums
     * @return
     */
    int canJump1(int[] nums){
        int n = nums.length;
        int end = 0;
        int farthest = 0;
        int jump = 0;
        for (int i = 0; i <n-1 ; i++) {
            farthest = Math.max(nums[i]+i,farthest);
            if(end == i){
                jump++;
                end = farthest;
            }
        }
        return jump;
    }
}
