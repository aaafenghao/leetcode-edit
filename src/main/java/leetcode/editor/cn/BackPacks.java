package leetcode.editor.cn;

/**
 * 背包问题
 * 给你一个可装载重点为W的背包和N个物品,每个物品有重量和价值两个属性
 * 其中第i个物品的重量wt[i],价值为val[i],现在用这个背包装物品，最多
 * 能装的价值是多少
 * N = 3 W = 4
 * wt = [2,1,3]
 * val = [4,2,3]
 *
 * 动态规划
 */
public class BackPacks {

    public static void main(String[] args) {
        //动态规划分析步骤
        //明确状态
        //明确选择
        //明确dp数组的定义
        //根据选择编写状态转移方程
        //动态规划算法框架
        //初始化base case
        //for 状态 in 状态的所有值
        //  for 状态 in 状态的所有值
        //    ...
        //      dp[状态1][状态2]... = 求最值(选择1,选择2...)

    }

    public int  backPacks(int N,int W,int[] wt,int[] val){
        //初始化base case
        int[][] dp = new int[N][W];//dp 数组的含义
        // dp[i][j] 对前i个物品,当前背包的容量为j,能装的最大价值为dp[i][j]
        dp[0][0] = 0;
        for (int i = 0; i < N; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < W; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if(j - wt[i-1] < 0){
                    //当前背包装不下,只能选择不装入背包
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i-1][j],//不装入,上一个物品的价值
                            //剩余重量下能装的最大价值
                            dp[i-1][j-wt[i-1]] + val[i-1]);//装入物品
                }

            }
        }
        //if判断,当前背包的容量小于物品的容量
        //不装物品,直接继承上一个物品的价值
        //装入物品,当前物品的价值+
        return dp[N][W];

    }
}
