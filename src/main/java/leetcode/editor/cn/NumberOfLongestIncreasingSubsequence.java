//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划

package leetcode.editor.cn;

import java.util.Arrays;



public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
        int[] array = new int[]{1,3,5,4,7};
        System.out.println(solution.findNumberOfLIS(array));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *   使用步骤:  1 明确base case 2 明确状态  3 明确选择  4 明确db函数的定义
     *   算法框架
     *   #初始化base case
     *   db[0][0]... = 0
     *   #进行状态转移
     *   for 状态1 in 状态1的所有取值
     *       for 状态2 in 状态2的所有取值
     *           ...
     *             dp[状态1][状态2]... = 求最值(选择1,选择2...)
      * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] array = new int[nums.length];
        int[] counter = new int[nums.length];
        Arrays.fill(counter,1);
        Arrays.fill(array,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                   if(nums[j] + 1 > nums[i]){
                    array[i] = 1 + nums[j];
                    counter[i] = counter[j];
                   } else if(nums[j] + 1 == nums[i]) {
                    counter[i] = counter[i]+counter[j];
                   }
            }
        }
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res = Math.max(res,array[i]);
        }
        int re = 0;
        for (int i = 0; i < counter.length; i++) {
            if(res == array[i]){
                re += counter[i];
            }
        }
        return re;
    }

    public int findNumberOfLIS1(int[] nums){
        //初始化base case
        if(nums.length == 0){
            return 0;
        }
        //进行状态转移
        int[] dp = new int[nums.length];//dp函数的定义--存储最长递增子序列的长度
        int[] count = new int[nums.length];//count函数的定义--当前长度的个数
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){//递增子序列
                    if(dp[j] + 1 > dp[i]){//遇到较长子序列
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]){//已经
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        int res = 0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(dp[i] == max){
                res += count[i];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}