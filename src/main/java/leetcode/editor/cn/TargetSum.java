//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划

package leetcode.editor.cn;
public class TargetSum {
    public static int result = 0;
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        //回溯算法框架
        //result = []
        //void backtrack(路径,选择列表):
        //   if 满足条件
        //      result.add(路径)
        //   return
        // for 选择 in 选择列表
        //    做选择
        //    backtrack(路径,选择列表)
        //    撤销选择

        return 0;
    }


    //可以使用备忘录模式消除重叠子问题
    private void backtrack(int[] nums,int i,int s){
        if(i == nums.length){
            if(s == 0){
                result++;
                return;
            }
        }
        s += nums[i];
        //添加-
        backtrack(nums,i+1,s);
        s -= nums[i];
        //添加+
        s -= nums[i];
        backtrack(nums,i+1,s);
        s += nums[i];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}