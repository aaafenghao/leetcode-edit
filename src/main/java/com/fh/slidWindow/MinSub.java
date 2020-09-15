package com.fh.slidWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串 --leetcode76
 */
public class MinSub {



    public String minWindow(String s,String t){
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char item = t.charAt(i);
            if(needs.containsKey(item)){
                needs.put(item,needs.get(item)+1);
            }else{
                needs.put(item,1);
            }
        }
        int left = 0;
        int right = 0;
        int valid = 0;

        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()){
            char ch = s.charAt(right);
            right++;
            if(needs.containsKey(ch)){
                if(window.containsKey(ch)){
                    window.put(ch,window.get(ch)+1);
                }else{
                    window.put(ch,1);
                }
                if(needs.get(ch).intValue() == window.get(ch).intValue()){
                    valid++;
                }
            }
            //满足条件
            while (valid == needs.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if(needs.containsKey(d)){
                    if(window.get(d).intValue() == needs.get(d).intValue()){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }

        return len == Integer.MAX_VALUE? "":s.substring(start,len);
    }


}
