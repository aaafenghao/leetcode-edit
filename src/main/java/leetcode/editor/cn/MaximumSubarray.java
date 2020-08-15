//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

package leetcode.editor.cn;
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = new int[]{1};
        System.out.println(solution.maxSubArray2(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i],nums[i] + dp[i-1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

        public int maxSubArray1(int[] nums) {
            int n = nums.length;
            if(n == 0){
                return 0;
            }
            int res = Integer.MIN_VALUE;
            int[] dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(nums[i],nums[i] + dp[i-1]);
                res = Math.max(res,dp[i]);
            }
            return res;
        }

        public int maxSubArray2(int[] nums){
            int n = nums.length;
            if (n == 0) return 0;
            // base case
            int dp_0 = nums[0];
            int dp_1 = 0, res = dp_0;

            for (int i = 1; i < n; i++) {
                // dp[i] = max(nums[i], nums[i] + dp[i-1])
                dp_1 = Math.max(nums[i], nums[i] + dp_0);
                dp_0 = dp_1;
                // 顺便计算最大的结果
                res = Math.max(res, dp_1);
            }
            return res;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}