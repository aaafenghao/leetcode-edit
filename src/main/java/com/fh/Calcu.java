package com.fh;

import java.util.Stack;

/**
 * 实现一个计算器
 * 可以计算
 * 3 * (2-6 /(3 -7))
 */
public class Calcu {

    public static void main(String[] args) {
        Calcu calcu = new Calcu();
        int covert = calcu.covert("384");
        System.out.println(covert);
    }

    public int covert(String nums){
        int c = 0;
        for (int i = 0; i < nums.length(); i++) {
            char item = nums.charAt(i);
            c = c * 10 + (item - '0');
        }
        return c;
    }

    public int addDelete(String nums){
        Stack<Integer> stk = new Stack<>();
        int c = 0;
        char pre = '+';
        for (int i = 0; i < nums.length(); i++) {
            char item = nums.charAt(i);
            if(isDigst(item)){
                c = c * 10 + (item - '0');
            }
            if(!isDigst(item) || i == nums.length()-1){
                switch (pre){
                    case '+':
                        stk.push(c);
                        break;
                    case '-':
                        stk.push(-c);
                        break;
                    case '*':
                        int num = stk.pop();
                        stk.push(num * c);
                        break;
                    case '/':
                        int num1 = stk.pop();
                        stk.push(num1 / c);
                        break;
                }
                pre = item;
                c = 0;
            }

        }
        int total = 0;
        while (!stk.isEmpty()){
            total = total + stk.pop();
        }
        return total;
    }

    public boolean isDigst(char c){
        if(c < '0' || c > '9'){
            return false;
        }
        return true;
    }

}
