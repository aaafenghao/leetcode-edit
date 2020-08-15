//你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。 
//
// 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。 
//
// 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。 
//
// 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。 
//
// 你的目标是确切地知道 F 的值是多少。 
//
// 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？ 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：K = 1, N = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
//否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
//如果它没碎，那么我们肯定知道 F = 2 。
//因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
// 
//
// 示例 2： 
//
// 输入：K = 2, N = 6
//输出：3
// 
//
// 示例 3： 
//
// 输入：K = 3, N = 14
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= 100 
// 1 <= N <= 10000 
// 
// Related Topics 数学 二分查找 动态规划

//最坏的情况下选择最少的

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;

public class SuperEggDrop {

    Map<String,Integer> temp = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new SuperEggDrop().new Solution();
        System.out.println(solution.superEggDrop2(3, 14));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //最坏情况下的最少次数
    // 可以添加备忘录模式
    public int superEggDrop(int K, int N) {
        String key = K + valueOf(N);
        //base case
        if(K == 1) return N;
        if(N == 0) return 0;
        if(temp.containsKey(key)){
            return temp.get(key);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <N+1 ; i++) {
            res = Math.min(res,
                    Math.max(
                            superEggDrop(K,N-i),//鸡蛋没碎,继续向上探索
                            superEggDrop(K-1,i-1))//鸡蛋碎了,继续向下探索
                            +1);
        }
        temp.put(key,res);
        return res;
    }

    //二分法
    //备忘录模式
    public int superEggDrop1(int k,int n){
        if(k == 1) return n;
        if(n == 0) return 0;
        int res = Integer.MAX_VALUE;
        int lo = 1,hi = n;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            int broke = superEggDrop1(k-1,mid - 1);
            int no_broke = superEggDrop1(k,n-mid);
            if(broke > no_broke){
                hi = mid - 1;
                res = Math.min(res,broke+1);
            } else {
                lo = mid + 1;
                res = Math.min(res,no_broke+1);
            }
        }
        return res;
    }

    //重新定义状态转移方程
    public int superEggDrop2(int k,int n){
        //dp[k][m] = n 有k个鸡蛋,最多尝试m次,最多给n层楼
        int[][] dp = new int[k+1][n+1];
        int m = 0;
        while (dp[k][m] < n){
            m++;
            for (int i = 1; i <= k ; i++) {
                dp[i][m] = dp[i][m-1] + dp[i-1][m-1] + 1;
            }
        }
        return m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}