package com.fh;

/**
 * 寻找缺失的元素
 *
 */
public class MissNumber {

    /**
     * 位运算
     * 一个数和本身做异或为0,和0做异或为本身
     * @param nums
     * @return
     */
    public int missNumber(int[] nums){
        int length = nums.length;
        int res = 0;
        res ^=length;
        for (int i = 0; i < length; i++) {
            res ^=nums[length];
        }
        return res;
    }

    /**
     * 等差数列求和
     * @param nums
     * @return
     */
    public int missNumber1(int[] nums){
        int length = nums.length;

        int expect = (0 + length) * (length + 1) / 2;
        int sum = 0;
        for (int i = 0; i <nums.length ; i++) {
            sum += nums[i];
        }
        return expect - sum;
    }

    /**
     *
     * @param nums
     * @return
     */
    public int missNumber2(int[] nums){
        int length = nums.length;
        int res = 0;
        res += length-0;
        for (int i = 0; i <length ; i++) {
            res += i - nums[i];
        }
        return res;
    }

}
