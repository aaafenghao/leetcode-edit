package com.fh;

/**
 * 如何同时寻找缺失和重复的元素
 *
 *
 */
public class MissingAndDuplicated {

    public static void main(String[] args) {

    }

    /**
     * 循环数组,获取对应的值,对应值对应的下标对应的值修改成负数
     *
     * 要求的是 1-N
     * 假设是 0-N-1  这样索引和下标就能一一对应了
     * @param nums
     */
    void findErrorNums(int[] nums){
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            //将对应的值-1,使其符合0-N-1
            int index = Math.abs(nums[i]) -1;
            if(nums[index] < 0){
                dup = Math.abs(nums[i]);
            }else {
                nums[index] *= -1;
            }
        }
        int missing = -1;
        for (int i = 0; i < n ; i++) {
            if(nums[i] > 0){
                //将其加+,使其符合 1-N
                missing = i + 1;
            }
        }

    }
}
