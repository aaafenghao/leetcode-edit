//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
//       String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        System.out.println(solution.isAnagram(s, t));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        //字母异位词--出现的次数一样,但是顺序不一样
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> sMap = new HashMap<Character, Integer>();
        Map<Character,Integer> tMap = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            Character item = s.charAt(i);
            Character target = t.charAt(i);
            if(sMap.containsKey(item)){
                sMap.put(item,sMap.get(item) + 1);
            }else{
                sMap.put(item,1);
            }
            if(tMap.containsKey(target)){
                tMap.put(target,tMap.get(target)+1);
            }else{
                tMap.put(target,1);
            }
        }
        for (Map.Entry<Character, Integer> entry:sMap.entrySet()){
            Integer integer = tMap.get(entry.getKey());
            if(integer == null){
                return false;
            }
            if(integer.intValue() != entry.getValue().intValue()){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}