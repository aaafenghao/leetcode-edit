//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法

package leetcode.editor.cn;
public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        return dp(s,p,0,0);
    }

    //可以添加备忘录模式
    public boolean dp(String text,String pattern,int i,int j){
        if(j == pattern.length()){
            return i == text.length();
        }
        //字符相等
        //需要匹配的字符为.可以匹配
        boolean first = i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');
        boolean ans;
        //如果遇到*
        if(j <= (pattern.length() -2) && pattern.charAt(j+1) == '*'){
                ans = dp(text,pattern,i,j+2) || //字符匹配0,文字不移动,匹配符跨过*
                        (first && dp(text,pattern,i+1,j));//字符匹配1,文字移动,匹配符不移动
        } else {
            //文本和匹配字符均向前推进一位
                ans =first && dp(text,pattern,i+1,j+1);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}