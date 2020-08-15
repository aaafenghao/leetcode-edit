//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(solution.checkInclusion(s1, s2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //s2是否包含s1的排列
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length() ; i++) {
            need.put(s1.charAt(i),0);
        }
        int left = 0,right = 0,valid=0;
        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,0);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while(right - left >= need.size()){
                if(valid == need.size()){
                    return true;
                }
                char s = s2.charAt(left);
                left++;
                if(need.containsKey(s)){
                    if(need.get(s).equals(window.get(s))){
                        valid--;
                    }
                    window.remove(s);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}