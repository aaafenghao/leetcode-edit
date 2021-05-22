package com.fh;

/**
 * 查询最长回文子串
 *
 * 回文串就是正读和反着读都一样的字符串
 *
 */
public class LongestReplyString {

    public String longestPalindrome(String s){
        String res = new String();
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s,i,i);
            String s2 = palindrome(s,i,i+1);
            res = res.length() > s1.length() ? res:s1;
            res = res.length() > s2.length() ? res:s2;
        }
        return res;
    }

    public String palindrome(String s,int l,int r){
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r-l-1);
    }
}
