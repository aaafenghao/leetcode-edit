package com.fh;

/**
 * 计算编辑距离
 *
 * 给定两个字符串s1和s2,计算出将s1转换成s2所是用的最小操作数
 *
 * 你可以对字符串做如下操作
 * 1.插入一个字符
 * 2.删除一个字符
 * 3.替换一个字符
 */
public class EditDistance {

    public static void main(String[] args) {

    }

    public int minDistance(String s1,String s2){
        return dp(s1,s1.length()-1,s2,s2.length()-1);
    }
    //s2去和s1匹配
    public int dp(String s1,int n,String s2,int m){
        char a1 = s1.charAt(n);
        char a2 = s2.charAt(m);
        if(a1 == a2){
            return dp(s1,n-1,s2,m);
        }else{
            int b1 = dp(s1,n,s2,m-1) + 1;//插入一个字符  直接在s1插入一个和s2一致的字符
            int b2 = dp(s1,n-1,s2,m) + 1;//删除一个字符  直接在s1上删除一个字符
            int b3 = dp(s1,n-1,s2,m-1);//替换一个字符 直接替换s1上的字符
            return Math.min(b3,Math.min(b1,b2));
        }
    }

}
