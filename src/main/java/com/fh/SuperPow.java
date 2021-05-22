package com.fh;

import java.util.Stack;

public class SuperPow {

    int base = 1337;
    //a^1234=a^4*a^1230
    int superPow(int a, Stack<Integer> b){
        if(b.isEmpty()){
            return 1;
        }
        Integer pop = b.pop();
        int mypow = mypow(a, pop);
        int mypow1 = mypow(superPow(a, b), 10);
        return mypow * mypow1;
    }
    //a^b==a*a^b-1
    //a^b==(a^b/2)^2
    int mypow(int a,int b){
        if(b == 0){
            return 1;
        }
        if(b % 2 == 1){
            return (a * mypow(a,b-1))%base;
        }else{
            int sub = mypow(a,b/2);
            return (sub * sub)%base;
        }
    }
}
