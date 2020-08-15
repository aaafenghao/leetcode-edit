//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(solution.minWindow(S, T));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();
        for (int i=0;i<t.length();i++){
            need.put(t.charAt(i),0);
        }

        int left = 0,right = 0,valid = 0;
        int start = 0,len = Integer.MAX_VALUE;
        while (right < s.length()){
            //c 将要加入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c,0);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //判断左侧窗口是否要收缩
            while (valid == need.size()){
                //在这里更新最小覆盖子串
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                //d 是将要移除窗口的字符串
                char d = s.charAt(left);
                //左移窗口
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.remove(d);
                }

            }
        }
        return len == Integer.MAX_VALUE ? "":s.substring(start-1,start+len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}