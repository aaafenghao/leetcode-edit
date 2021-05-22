package com.fh;

/**
 * 寻找最长回文串
 */
public class Palindrome {

    String longestPalindrome(String s){
        String subStr = null;
        for (int i = 0; i < s.length(); i++) {
            String s1 = panlindrome(s,i,i);
            String s2 = panlindrome(s,i,i++);
            subStr = s.length() > s1.length()?subStr:s1;
            subStr = s.length() > s2.length()?subStr:s2;

        }
        return subStr;
    }

    private String panlindrome(String s, int i, int i1) {
        while (i >=0 && i1 < s.length() && s.charAt(i) == s.charAt(i1)){
            i--;
            i1++;
        }
        return s.substring(i+1,i1-i-1);
    }
}
