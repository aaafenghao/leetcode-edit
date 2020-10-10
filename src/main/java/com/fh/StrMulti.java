package com.fh;

/**
 * 字符串乘法
 * 当语言提供的类型相乘容易溢出
 *
 */
public class StrMulti {

    public static void main(String[] args) {
        StrMulti strMulti = new StrMulti();
        System.out.println(strMulti.multiply("123", "45"));
    }

    String multiply(String sum1,String sum2){
        int m = sum1.length(),n=sum2.length();
        int[] res = new int[m+n];
        for (int i = m-1; i >=0; i--) {
            for (int j = n-1; j >=0 ; j--) {
                //**************************************************
                int mul = (sum1.charAt(i)-'0') * (sum2.charAt(j)-'0');
                //对应的索引位置
                int p1 = i+j,p2=i+j+1;
                int sum = mul + res[p2];
                res[p2] = sum%10;
                res[p1] += sum/10;
                //**************************************************
                // 1 2 3
                //   4 5
                //---------
                //   1 5
                // 1 0
             //  0 5
             //    1 2
             //  0 8
            // 0 4
            //---------------
            //        1 5
            }
        }
        //结果前缀可能存的0
        int i=0;
        while (i<res.length && res[i] == 0){
            i++;
        }
        //将计算结果转换为字符串
        StringBuffer str = new StringBuffer();
        for (;i<res.length;i++){
            str.append(res[i]);
        }
        return str.length() == 0?"0":str.toString();
    }
}
