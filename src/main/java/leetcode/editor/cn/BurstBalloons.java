//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 lef
//t 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划

package leetcode.editor.cn;

import java.util.ArrayList;

public class BurstBalloons {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
        return 0;
    }
    //回朔算法
    public void backTrack(int[] nums,int score){
        if(nums.length == 0){
            res = Math.max(res,score);
            return;
        }
    }
    //动态规划
    public int maxCoins1(int[] nums){
        int n = nums.length;
        //添加两侧的虚拟气球
        int[] points = new int[n + 2];
        points[0] = points[n+1] = 1;
        for (int i = 1; i <=n ; i++) {
            points[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        //开始进行状态转移
        //i从下到上
        for (int i = n; i >=0 ; i--) {
            //j从左向右
            for (int j = i+1; j < n+2; j++) {
                //最后戳破的气球是哪一个
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] +
                            points[i] * points[j] * points[k]   );
                }
            }
        }
        return dp[0][n+1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}