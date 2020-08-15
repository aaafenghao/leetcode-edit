//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn;

import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        //所有可能的,并且有效的括号
        generate(0,0,n,"");
        return null;
    }

    public void generate(int left,int right,int n,String s){
        if(left == n && right == n){
            System.out.println(s);
            return;
        }
        if(left < n){
            generate(left +1,right,n,s+"(");
        }
        if(right < n && right < left){
            generate(left,right+1,n,s+")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}