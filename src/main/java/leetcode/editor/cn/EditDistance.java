//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;
public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {

        return 0;
    }

    //动态规划
    public int minDistance2(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int add = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add,Math.min(delete,replace));
                }
            }
        }
        return dp[m][n];
    }

    //递归
    public int minDistance1(String s1,String s2,int i,int j){
      if(i == -1) return j + 1;
      if(j == -1) return i + 1;

      if(s1.charAt(i) == s2.charAt(j)){
          return minDistance1(s1,s2,i-1,j-1);
      } else {
          int add = minDistance1(s1, s2, i, j - 1) + 1;
          int delete = minDistance1(s1, s2, i - 1, j) + 1;
          int replace = minDistance1(s1,s2,i-1,j-1) + 1;
          return Math.min(add,Math.min(delete,replace));
      }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}